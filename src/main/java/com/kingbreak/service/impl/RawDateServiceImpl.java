package com.kingbreak.service.impl;/**
 * @author lishaolong
 * @Date 2021/12/8
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbreak.entity.RawData;
import com.kingbreak.mapper.RawDateMapper;
import com.kingbreak.service.RawDateService;
import org.springframework.stereotype.Service;

/**
 * @author li
 * @date 2021/12/8
 */
@Service
public class RawDateServiceImpl extends ServiceImpl<RawDateMapper, RawData> implements RawDateService {
}
