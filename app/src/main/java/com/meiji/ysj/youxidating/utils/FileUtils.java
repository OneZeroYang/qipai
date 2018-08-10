package com.meiji.ysj.youxidating.utils;


import android.content.Context;
import android.os.Environment;
import android.util.Base64;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


/**
 * 文件操作工具
 * Created by Jusenr on 2016/12/10.
 */
public final class FileUtils {
    public static final String TAG = FileUtils.class.getSimpleName();
    public static final int BYTE = 1024;

    /**
     * 格式化单位
     *
     * @param size
     * @return
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / BYTE;
        if (kiloByte < 1) {
            return size + "B";
        }

        double megaByte = kiloByte / BYTE;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte / BYTE;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = gigaByte / BYTE;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }

    /**
     * 获取缓存文件大小
     *
     * @param context
     * @return
     */
    public static String getTotalCacheSize(Context context) {
        long cacheSize = getFolderSize(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheSize += getFolderSize(context.getExternalCacheDir());
        }
        return getFormatSize(cacheSize);
    }

    /**
     * 清除应用缓存文件
     *
     * @param context
     */
    public static void clearAllCache(Context context) {
        delete(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            delete(context.getExternalCacheDir());
        }
    }

    /**
     * 获取文件大小
     *
     * @param file
     * @return
     * @throws Exception
     */
    //Context.getExternalFilesDir() --> SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据
    //Context.getExternalCacheDir() --> SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
    public static long getFolderSize(File file) {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * 读取文件内容
     *
     * @param file    文件
     * @param charset 文件编码
     * @return 文件内容
     */
    public static String readFile(File file, String charset) {
        String fileContent = "";
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), charset);
            BufferedReader reader = new BufferedReader(read);
            String line = "";
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i == 0)
                    fileContent = line;
                else
                    fileContent = fileContent + "\n" + line;
                i++;
            }
            read.close();
        } catch (Exception e) {
       //     Logger.e("读取文件内容操作出错", e);
        }
        return fileContent;
    }

    /**
     * 读取文件内容
     *
     * @param file 文件
     * @return 文件内容
     */
    public static String readFile(File file) {
        return readFile(file, "UTF-8");
    }

    /**
     * 获取文件的SHA1值
     *
     * @param file 目标文件
     * @return 文件的SHA1值
     */
    public static String getSHA1ByFile(File file) {
        if (file == null || !file.exists()) return "文件不存在";
        long time = System.currentTimeMillis();
        InputStream in = null;
        String value = null;
        try {
            in = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            int numRead = 0;
            while (numRead != -1) {
                numRead = in.read(buffer);
                if (numRead > 0) digest.update(buffer, 0, numRead);
            }
            byte[] sha1Bytes = digest.digest();
            String t = new String(buffer);
            value = convertHashToString(sha1Bytes);
        } catch (Exception e) {
          //  Logger.e(e);
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                //    Logger.e(e);
                }
        }
        return value;
    }

    /**
     * @param hashBytes
     * @return
     */
    private static String convertHashToString(byte[] hashBytes) {
        String returnVal = "";
        for (int i = 0; i < hashBytes.length; i++) {
            returnVal += Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1);
        }
        return returnVal.toLowerCase();
    }

    /**
     * 获取上传文件的文件名
     *
     * @param filePath
     * @return
     */
    public static String getFileName(String filePath) {
        String filename = new File(filePath).getName();
        if (filename.length() > 80) {
            filename = filename.substring(filename.length() - 80, filename.length());
        }
        return filename;
    }

    /**
     * 创建文件夹
     *
     * @param mkdirs 文件夹
     */
    public static boolean createMkdirs(File mkdirs) {
        return mkdirs.mkdirs();
    }

    /**
     * 创建文件
     *
     * @param file 文件
     */
    public static boolean createFile(File file) {
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /**
     * 获得下载文件名
     *
     * @param url 下载url
     * @return 文件名
     */
    public static String getDownloadFileName(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    /**
     * 获得应用的图片保存目录
     *
     * @return
     */
    public static String getPicDirectory(Context context) {
        File picFile = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (picFile != null) {
            return picFile.getAbsolutePath();
        } else {
            return context.getFilesDir().getAbsolutePath() + "/Pictures";
        }
    }

    /**
     * 解压assets的zip压缩文件到指定目录
     *
     * @param context   上下文对象
     * @param assetName 压缩文件名
     * @param outputDir 输出目录
     * @param isReWrite 是否覆盖
     * @throws IOException
     */
//    public static void unZipInAsset(Context context, String assetName, String outputDir, boolean isReWrite) throws IOException {
//        String outputDirectory = BasicApplication.sdCardPath + File.separator + outputDir;
//        // 创建解压目标目录
//        File file = new File(outputDirectory);
//        // 如果目标目录不存在，则创建
//        if (!file.exists()) file.mkdirs();
//        // 打开压缩文件
//        InputStream inputStream = ResourcesUtils.getAssets(context).open(assetName);
//        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
//        // 读取一个进入点
//        ZipEntry zipEntry = zipInputStream.getNextEntry();
//        // 使用1Mbuffer
//        byte[] buffer = new byte[1024 * 1024];
//        // 解压时字节计数
//        int count = 0;
//        // 如果进入点为空说明已经遍历完所有压缩包中文件和目录
//        while (zipEntry != null) {
//            // 如果是一个目录
//            if (zipEntry.isDirectory()) {
//                file = new File(outputDirectory + File.separator + zipEntry.getName());
//                // 文件需要覆盖或者是文件不存在
//                if (isReWrite || !file.exists()) file.mkdir();
//            } else {
//                // 如果是文件
//                file = new File(outputDirectory + File.separator + zipEntry.getName());
//                // 文件需要覆盖或者文件不存在，则解压文件
//                if (isReWrite || !file.exists()) {
//                    file.createNewFile();
//                    FileOutputStream fileOutputStream = new FileOutputStream(file);
//                    while ((count = zipInputStream.read(buffer)) > 0)
//                        fileOutputStream.write(buffer, 0, count);
//                    fileOutputStream.close();
//                }
//            }
//            // 定位到下一个文件入口
//            zipEntry = zipInputStream.getNextEntry();
//        }
//        zipInputStream.close();
//    }

    /**
     * 解压sdCard的zip压缩文件到指定目录
     *
     * @param zipPath   压缩文件路径
     * @param outputDir 输出目录
     * @param isReWrite 是否覆盖
     * @throws IOException
     */
//    public static void unZipInSdCard(String zipPath, String outputDir, boolean isReWrite) throws IOException {
//        String outputDirectory = BasicApplication.sdCardPath + File.separator + outputDir;
//        // 创建解压目标目录
//        File file = new File(outputDirectory);
//        // 如果目标目录不存在，则创建
//        if (!file.exists()) file.mkdirs();
//        // 打开压缩文件
//        InputStream inputStream = new FileInputStream(new File(zipPath));
//        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
//        // 读取一个进入点
//        ZipEntry zipEntry = zipInputStream.getNextEntry();
//        // 使用1Mbuffer
//        byte[] buffer = new byte[1024 * 1024];
//        // 解压时字节计数
//        int count = 0;
//        // 如果进入点为空说明已经遍历完所有压缩包中文件和目录
//        while (zipEntry != null) {
//            // 如果是一个目录
//            if (zipEntry.isDirectory()) {
//                file = new File(outputDirectory + File.separator + zipEntry.getName());
//                // 文件需要覆盖或者是文件不存在
//                if (isReWrite || !file.exists()) file.mkdir();
//            } else {
//                // 如果是文件
//                file = new File(outputDirectory + File.separator + zipEntry.getName());
//                // 文件需要覆盖或者文件不存在，则解压文件
//                if (isReWrite || !file.exists()) {
//                    file.createNewFile();
//                    FileOutputStream fileOutputStream = new FileOutputStream(file);
//                    while ((count = zipInputStream.read(buffer)) > 0)
//                        fileOutputStream.write(buffer, 0, count);
//                    fileOutputStream.close();
//                }
//            }
//            // 定位到下一个文件入口
//            zipEntry = zipInputStream.getNextEntry();
//        }
//        zipInputStream.close();
//    }

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return 是否刪除成功
     */
    public static boolean delete(String filePath) {
        File file = new File(filePath);
        return delete(file);
    }

    /**
     * 删除文件
     *
     * @param file 文件
     * @return 是否刪除成功
     */
    public static boolean delete(File file) {
        if (file == null || !file.exists()) return false;
        if (file.isFile()) {
            final File to = new File(file.getAbsolutePath() + System.currentTimeMillis());
            file.renameTo(to);
            to.delete();
        } else {
            File[] files = file.listFiles();
            if (files != null && files.length > 0)
                for (File innerFile : files) {
                    delete(innerFile);
                }
            final File to = new File(file.getAbsolutePath() + System.currentTimeMillis());
            file.renameTo(to);
            return to.delete();
        }
        return false;
    }

    /**
     * 获得文件内容
     *
     * @param filePath 文件路径
     * @return 文件内容
     */
    public static String getFileContent(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
                String result = null;
                String s = null;
                while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                    result = result + "\n" + s;
                }
                br.close();
                return result;
            } catch (Exception e) {
                e.printStackTrace();
          //      Logger.e(e);
            }
        } else {
            return null;
        }
        return null;
    }

    /**
     * 保存文本到文件
     *
     * @param fileName 文件名字
     * @param content  内容
     * @param append   是否累加
     * @return 是否成功
     */
    public static boolean saveTextValue(String fileName, String content, boolean append) {
        try {
            File textFile = new File(fileName);
            if (!append && textFile.exists()) textFile.delete();
            FileOutputStream os = new FileOutputStream(textFile);
            os.write(content.getBytes("UTF-8"));
            os.close();
        } catch (Exception ee) {
            return false;
        }
        return true;
    }

    /**
     * 删除目录下所有文件
     *
     * @param Path 路径
     */
    public static void deleteAllFile(String Path) {
        // 删除目录下所有文件
        File path = new File(Path);
        File files[] = path.listFiles();
        if (files != null)
            for (File tfi : files) {
                if (tfi.isDirectory())
                    System.out.println(tfi.getName());
                else
                    tfi.delete();
            }
    }

    /**
     * 保存文件
     *
     * @param in       文件输入流
     * @param filePath 文件保存路径
     */
    public static File saveFile(InputStream in, String filePath) {
        File file = new File(filePath);
        byte[] buffer = new byte[4096];
        int len = 0;
        FileOutputStream fos = null;
        try {
            FileUtils.createFile(file);
            fos = new FileOutputStream(file);
            while ((len = in.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
        } catch (IOException e) {
       //     Logger.e(e);
        } finally {
            try {
                if (in != null) in.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
       //         Logger.e(e);
            }
        }
        return file;
    }

    /**
     * 文件是否存在
     *
     * @param path 文件路径
     * @return 文件是否存在
     */
//    public static boolean isExists(String path) {
//        File file = new File(path);
//        return file.exists();
//    }

    /**
     * 文件Base64加密
     *
     * @param path
     * @return
     */
    public static String fileToBase64String(String path) {
        FileInputStream inputStream = null;
        try {
            File file = new File(path);
            inputStream = new FileInputStream(file);
            byte[] fileBytes = new byte[inputStream.available()];
            inputStream.read(fileBytes);
            String base64String = Base64.encodeToString(fileBytes, Base64.DEFAULT);
            return base64String;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    /**
     * 判断文件是否存在
     *
     * @param strPath
     * @return
     */
    public boolean isExists(String strPath) {
        if (strPath == null) {
            return false;
        }

        final File strFile = new File(strPath);

        if (strFile.exists()) {
            return true;
        }
        return false;

    }
}
