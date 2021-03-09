package com.example.backend.Elasticsearch.impl;

import com.example.backend.Elasticsearch.EsProductService;
import com.example.backend.Elasticsearch.dao.EsProductDao;
import com.example.backend.Elasticsearch.pojo.EsProduct;
import com.example.backend.Elasticsearch.repository.EsProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
 import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 商品搜索管理Service实现类
 * Created by macro on 2018/6/19.
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);
    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductRepository productRepository;

    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public EsProduct create(Long id) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        return null;
    }


}