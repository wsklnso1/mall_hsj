package com.hsj.mall.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mall_hsj_mbg.mapper.UmsAdminMapper;
import org.mall_hsj_mbg.mapper.UmsMemberLoginLogMapper;
import org.mall_hsj_mbg.model.UmsAdmin;
import org.mall_hsj_mbg.model.UmsAdminExample;
import org.mall_hsj_mbg.model.UmsAdminLoginLog;
import org.mall_hsj_mbg.model.UmsPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hsj.mall.dao.UmsAdminPermissionRelationDao;
import com.hsj.mall.dao.UmsAdminRoleRelationDao;
import com.hsj.mall.service.UmsAdminService;
import com.hsj.mall.util.JwtTokenUtil;

import org.mall_hsj_mbg.mapper.UmsAdminLoginLogMapper;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UmsAdminLoginLogMapper loginLogMapper;

	@Autowired
	private UmsAdminMapper adminMapper;

	@Autowired
	private UmsAdminPermissionRelationDao adminPermissionRelationDao;

	@Autowired
	private UmsAdminRoleRelationDao adminRoleRelationDao;

	@Override
	public String login(String username, String password) {
		String token = null;
		// 密码需要客户端加密后传递
		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (!passwordEncoder.matches(password, userDetails.getPassword())) {
				throw new BadCredentialsException("密码不正确");
			}
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			token = jwtTokenUtil.generateToken(userDetails);
			// updateLoginTimeByUsername(username);
			insertLoginLog(username);
		} catch (AuthenticationException e) {
			LOGGER.warn("登录异常:{}", e.getMessage());
		}
		return token;
	}

	/**
	 * 添加登录记录
	 * 
	 * @param username
	 *            用户名
	 */
	private void insertLoginLog(String username) {
		UmsAdmin admin = getAdminByUsername(username);
		UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
		loginLog.setAdminId(admin.getId());
		loginLog.setCreateTime(new Date());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		loginLog.setIp(request.getRemoteAddr());
		loginLogMapper.insert(loginLog);
	}

	@Override
	public UmsAdmin getAdminByUsername(String username) {
		UmsAdminExample example = new UmsAdminExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<UmsAdmin> adminList = adminMapper.selectByExample(example);
		if (adminList != null && adminList.size() > 0) {
			return adminList.get(0);
		}
		return null;
	}

	@Override
	public List<UmsPermission> getPermissionList(Long adminId) {
		return adminRoleRelationDao.getPermissionList(adminId);
	}

	@Override
	public UmsAdmin getItem(Long id) {
		return adminMapper.selectByPrimaryKey(id);
	}
}
