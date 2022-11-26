package com.kennyouchou.commons.annotation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennyouchou.commons.annotation.entity.Log;
import com.kennyouchou.commons.annotation.mapper.LogMapper;
import com.kennyouchou.commons.annotation.service.LogService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
