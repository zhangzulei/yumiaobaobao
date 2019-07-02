package com.yumiaobaobao.app.common.utils.aliyunossutil;

import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by WH on 2019/04/04.
 *
 */

public class LocalDelete {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LocalDelete.class);

    /**
     * 删除文件
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            logger.info("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile())
                return deleteFile(fileName);
            else
                return deleteDirectory(fileName);
        }
    }
    /**
     * 删除单个文件
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                logger.info("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                logger.info("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            logger.info("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }


    /**
     * 删除目录及目录下的文件
     *
     */
    public static boolean deleteDirectory(String dir) {
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            logger.info("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            logger.info("删除目录失败！");
            return false;
        }
        if (dirFile.delete()) {
            logger.info("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }
}
