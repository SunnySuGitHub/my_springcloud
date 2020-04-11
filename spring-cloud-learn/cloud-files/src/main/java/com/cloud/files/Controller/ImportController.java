package com.cloud.files.Controller;

import com.cloud.files.Service.ExcelImport.AmmeterImportService;
import com.cloud.files.Service.ExcelImport.WaterImportService;
import com.cloud.files.utils.ResponseHandler;
import com.cloud.files.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 10:52
 * 导入操作
 */
@RestController()
@CrossOrigin("*")
public class ImportController {

    @Autowired
    WaterImportService waterImportService;

    @Autowired
    AmmeterImportService ammeterImportService;

    @PostMapping("/watermeter")
    public ResultData watermeterImport(HttpServletRequest request) {
        return ResponseHandler.doHandle(() -> waterImportService.checkOrRead(request));
    }

    @PostMapping("/ammeter")
    public ResultData ammeterImport(HttpServletRequest request) {
        return ResponseHandler.doHandle(() -> ammeterImportService.checkOrRead(request));
    }

    @GetMapping("txTest")
    public ResultData txTest(@RequestParam("txId") int txId) {
        return ResponseHandler.doHandle(() -> ammeterImportService.test(txId));
    }
}
