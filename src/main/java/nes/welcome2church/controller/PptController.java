package nes.welcome2church.controller;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xslf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/ppt")
public class PptController {
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse response) throws Exception {
        XMLSlideShow ppt = createPpt();
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + "newcustomer.pptx");
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        ppt.write(os);
    }

    private XMLSlideShow createPpt() {
        //creating presentation
        XMLSlideShow ppt = new XMLSlideShow();

        int[] integers = {1, 2, 3, 4};

        /* 开始遍历 */

        for (int y : integers) {

            XSLFSlide slide = ppt.createSlide();

            //converting it into a byte array
            //背景
            byte[] bt = new byte[0];
            try {
                bt = FileUtils.readFileToByteArray(new File("src/pic/background.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int idx = ppt.addPicture(bt, XSLFPictureData.PICTURE_TYPE_PNG);
            XSLFPictureShape pic = slide.createPicture(idx);
            pic.setAnchor(new Rectangle2D.Double(0, 0, 720, 580));

            //头像
            byte[] bt1 = new byte[0];
            try {
                bt1 = FileUtils.readFileToByteArray(new File("src/pic/head.jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int idx1 = ppt.addPicture(bt1, XSLFPictureData.PICTURE_TYPE_PNG);
            XSLFPictureShape pic1 = slide.createPicture(idx1);
            pic1.setAnchor(new Rectangle(50, 200, 200, 200));

            //背景slogan
            byte[] bt2 = new byte[0];
            try {
                bt2 = FileUtils.readFileToByteArray(new File("src/pic/slogen.jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int idx2 = ppt.addPicture(bt2, XSLFPictureData.PICTURE_TYPE_PNG);
            XSLFPictureShape pic2 = slide.createPicture(idx2);
            pic2.setAnchor(new Rectangle2D.Double(0, 0, 720, 150));

            //Table
            Object[][] datas = {{"--", "--"}, {"姓名", "--"}, {"性别", "--"}, {"年龄", "--"}, {"学校", "--"}, {"--", "--"}};
            XSLFTable table = slide.createTable();//创建表格
            table.setAnchor(new Rectangle2D.Double(300, 200, 300, 200));
            for (int i = 0; i < datas.length; i++) {
                XSLFTableRow tableRow = table.addRow(); //创建表格行
                for (int j = 0; j < datas[i].length; j++) {
                    XSLFTableCell tableCell = tableRow.addCell();//创建表格单元格
                    XSLFTextParagraph p = tableCell.addNewTextParagraph();
                    XSLFTextRun tr = p.addNewTextRun();
                    tr.setText(String.valueOf(datas[i][j]));

                    tableCell.setFillColor(Color.getColor("0xdd7e6b"));
                    p.setTextAlign(TextAlign.CENTER);
                    tableCell.setVerticalAlignment(VerticalAlignment.MIDDLE);

                    tableCell.setBorderBottom(1);
                    tableCell.setBorderLeft(1);
                    tableCell.setBorderTop(1);
                    tableCell.setBorderRight(1);
                    tableCell.setBorderBottomColor(Color.BLACK);
                    tableCell.setBorderLeftColor(Color.BLACK);
                    tableCell.setBorderTopColor(Color.BLACK);
                    tableCell.setBorderRightColor(Color.BLACK);
                }

                tableRow.setHeight(30);
            }

            //设置列宽
            table.setColumnWidth(0, 150);
            table.setColumnWidth(1, 200);

        }
        return ppt;
    }
}