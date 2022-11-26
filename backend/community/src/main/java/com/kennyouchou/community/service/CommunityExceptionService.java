package com.kennyouchou.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.kennyouchou.commons.exception.LExceException;
import com.kennyouchou.community.bo.QueryExceptionBo;
import com.kennyouchou.community.entity.CommunityException;
import com.kennyouchou.community.vo.ExceptionVo;

import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 社区异常表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-02
 */
public interface CommunityExceptionService extends IService<CommunityException> {

    /**
     * 查询异常列表
     * @param pageNum      页码
     * @param pageSize     页大小
     * @param queryExceptionBo  异常查询条件
     * @return com.github.pagehelper.PageInfo<com.kennyouchou.community.vo.ExceptionBo>
     * @author kennyouchou
     * @since 2022/10/2 15:18
     **/
    PageInfo<ExceptionVo> findByQuery(Integer pageNum, Integer pageSize, QueryExceptionBo queryExceptionBo);

    /**
     * 修改异常状态
     * @param id           异常id
     * @param status       异常状态
     * @param result       处理结果
     * @param isTransferredCode 是否转码
     * @author kennyouchou
     * @since 2022/10/3 12:50
     **/
    @Transactional(rollbackFor = Exception.class)
    void updateStatus(String id, Integer status, String result, String isTransferredCode) throws LExceException;

}
