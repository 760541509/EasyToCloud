//package com.yingtongquan.employees.util;
//
//import cn.hutool.json.JSONUtil;
//import com.yingtongquan.employees.goodsShop.pojo.ShopGoodsAddInfoVo;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.text.DecimalFormat;
//import java.util.*;
//import java.util.function.BiConsumer;
//import java.util.function.Consumer;
//
///**
// * 导入商品
// */
//public class GoodsExcelData {
//
//    private XSSFSheet sheet;
//
//    /**
//     * 构造函数，初始化excel数据
//     * @param filePath  excel路径
//     * @param sheetName sheet表名
//     */
//    GoodsExcelData(String filePath,String sheetName){
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(filePath);
//            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
//            //获取sheet
//            sheet = sheets.getSheet(sheetName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 根据行和列的索引获取单元格的数据
//     * @param row
//     * @param column
//     * @return
//     */
//    public String getExcelDateByIndex(int row,int column){
//        XSSFRow row1 = sheet.getRow(row);
//        String cell = row1.getCell(column).toString();
//        return cell;
//    }
//
//    /**
//     * 根据某一列值为“******”的这一行，来获取该行第x列的值
//     * @param caseName
//     * @param currentColumn 当前单元格列的索引
//     * @param targetColumn 目标单元格列的索引
//     * @return
//     */
//    public String getCellByCaseName(String caseName,int currentColumn,int targetColumn){
//        String operateSteps="";
//        //获取行数
//        int rows = sheet.getPhysicalNumberOfRows();
//        for(int i=0;i<rows;i++){
//            XSSFRow row = sheet.getRow(i);
//            String cell = row.getCell(currentColumn).toString();
//            if(cell.equals(caseName)){
//                operateSteps = row.getCell(targetColumn).toString();
//                break;
//            }
//        }
//        return operateSteps;
//    }
//
//    //打印excel数据
//    public void readExcelData(){
//        //获取行数
//        int rows = sheet.getPhysicalNumberOfRows();
//        for(int i=0;i<rows;i++){
//            //获取列数
//            XSSFRow row = sheet.getRow(i);
//            int columns = row.getPhysicalNumberOfCells();
//            for(int j=0;j<columns;j++){
//                String cell = row.getCell(j).toString();
//                System.out.println(cell);
//            }
//        }
//    }
//
//    //测试方法
//    public static void main(String[] args){
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream("D:/EasyToCloud/employees/src/main/resources/test2.xlsx");
//            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
//            XSSFSheet xSSFSheet = sheets.getSheetAt(0);
//            XSSFRow shopRow  = xSSFSheet.getRow(0);
//
//            String shopDesc = getString(shopRow.getCell(0));
//            String shopId = shopDesc.substring(shopDesc.indexOf("：")+1,shopDesc.length());
//
//            System.out.println("shopId========"+shopId);
//
//            XSSFRow titleRow  = xSSFSheet.getRow(1);
//
//            List<Map<String, String>> goodsListInfo = new ArrayList<>();
//
//            for (int rowIndex = 2; rowIndex < xSSFSheet.getPhysicalNumberOfRows(); rowIndex++) {
//                XSSFRow xssfRow = xSSFSheet.getRow(rowIndex);
//                if (xssfRow == null) {
//                    continue;
//                }
//                Map<String, String> map = new LinkedHashMap<String, String>();
//                //循环取每个单元格(cell)的数据
//                for (int cellIndex = 0; cellIndex < xssfRow.getPhysicalNumberOfCells(); cellIndex++) {
//                    XSSFCell titleCell = titleRow.getCell(cellIndex);
//                    XSSFCell xssfCell = xssfRow.getCell(cellIndex);
//                    map.put(getString(titleCell),getString(xssfCell));
//                }
//                goodsListInfo.add(map);
//            }
//
//
//            List<ShopGoodsAddInfoVo> goodsAddInfoVoList = new ArrayList<>();
//
//            //获取商品
//            Map<String, List<Map<String, String>>> goodsListMap = new LinkedHashMap<>();
//
//            goodsListInfo.forEach(new Consumer<Map<String, String>>() {
//                @Override
//                public void accept(Map<String, String> stringStringMap) {
//                    //商品名称
//                    String name = stringStringMap.get("商品名称");
//                    String specName = stringStringMap.get("规格");
//                    String artNo = stringStringMap.get("货号");
//                    String barCode = stringStringMap.get("条码");
//                    String unitName = stringStringMap.get("单位");
//                    String store = stringStringMap.get("现有库存(基本单位)");
//
//                    String retailPrice = stringStringMap.get("零售价");
//                    String wholesalePrice = stringStringMap.get("批发价");
//                    String price1 = stringStringMap.get("价格1");
//                    String price2 = stringStringMap.get("价格2");
//                    String price3 = stringStringMap.get("价格3");
//                    String price4 = stringStringMap.get("价格4");
//                    String price5 = stringStringMap.get("价格5");
//                    String price6 = stringStringMap.get("价格6");
//                    String carouselImage = stringStringMap.get("轮播图");
//                    String status = stringStringMap.get("是否上架");
//
//                    goodsListMap.computeIfAbsent(name, k -> new ArrayList<>());
//                    List<Map<String, String>> goodsList = goodsListMap.get(name);
//                    Map<String, String> mapInfo = new HashMap<>();
//                    mapInfo.put("name",name);
//                    mapInfo.put("specName",specName);
//                    mapInfo.put("artNo",artNo);
//                    mapInfo.put("barCode",barCode);
//                    mapInfo.put("unitName",unitName);
//                    mapInfo.put("store",store);
//                    mapInfo.put("retailPrice",retailPrice);
//                    mapInfo.put("wholesalePrice",wholesalePrice);
//                    mapInfo.put("price1",price1);
//                    mapInfo.put("price2",price2);
//                    mapInfo.put("price3",price3);
//                    mapInfo.put("price4",price4);
//                    mapInfo.put("price5",price5);
//                    mapInfo.put("price6",price6);
//                    mapInfo.put("carouselImage",carouselImage);
//                    mapInfo.put("status",status);
//
//                    goodsList.add(mapInfo);
//
//                }
//            });
//
//            System.out.println("表格商品数据============"+ JSONUtil.toJsonStr(goodsListMap));
//
//            //转换接口需要的数据
//
//            //根据门店Id 获取仓库。
//            ShopGoodsAddInfoVo.WarehouseListBean warehouseListBean = new ShopGoodsAddInfoVo.WarehouseListBean();
//            warehouseListBean.setFkGoodsWarehouseAreaId(0);
//            warehouseListBean.setFkWarehouseId(1);
//            warehouseListBean.setName("默认仓库");
//
//            goodsListMap.forEach(new BiConsumer<String, List<Map<String, String>>>() {
//                @Override
//                public void accept(String s, List<Map<String, String>> maps) {
//                    ShopGoodsAddInfoVo shopGoodsAddInfoVo = new ShopGoodsAddInfoVo();
//                    shopGoodsAddInfoVo.setName(s);
//                    shopGoodsAddInfoVo.setStatus(1);
//
//                    shopGoodsAddInfoVo.setWarehouseList(new ArrayList<>());
//                    shopGoodsAddInfoVo.getWarehouseList().add(warehouseListBean);
//
//                    List<ShopGoodsAddInfoVo.UnitListBean> unitList = new ArrayList<>();
//                    List<ShopGoodsAddInfoVo.GoodsSkuListBean> goodsSkuList = new ArrayList<>();
//
//                    maps.forEach(stringStringMap -> {
//
//                        //是否上架
//                        if(shopGoodsAddInfoVo.getStatus()==null){
//                            if("是".equals(stringStringMap.get("status"))){
//                                shopGoodsAddInfoVo.setStatus(1);
//                            }else{
//                                shopGoodsAddInfoVo.setStatus(0);
//                            }
//                        }
//                        //轮播图
//                        if(shopGoodsAddInfoVo.getCarouselImage()==null||"".equals(shopGoodsAddInfoVo.getCarouselImage())){
//                            shopGoodsAddInfoVo.setCarouselImage(stringStringMap.get("carouselImage"));
//                        }
//                        //单位
//                        if(unitList.size()==0){
//                            //个-盒;10-箱;20
//                            String unitName =  stringStringMap.get("unitName");
//                            String[] unitNameArr = unitName.split("-");
//                            for (int i = 0; i < unitNameArr.length; i++) {
//                                ShopGoodsAddInfoVo.UnitListBean unitListBean = new ShopGoodsAddInfoVo.UnitListBean();
//                                String nameStr = unitNameArr[i];
//                                if(i==0){
//                                    unitListBean.setAmount(1);
//                                    unitListBean.setName(nameStr);
//                                    unitListBean.setPrice(0);
//                                }else{
//                                    String[] unitNameAndNumArr = nameStr.split(";");
//                                    if(unitNameAndNumArr.length==2){
//                                        unitListBean.setName(unitNameAndNumArr[0]);
//                                        unitListBean.setAmount(Integer.valueOf(unitNameAndNumArr[1]));
//                                        unitListBean.setPrice(0);
//                                    }
//                                    else {
//                                        throw new IllegalArgumentException("商品单位格式错误");
//                                    }
//                                }
//                                unitList.add(unitListBean);
//                            }
//                        }
//
//                        //sku信息
//                        ShopGoodsAddInfoVo.GoodsSkuListBean goodsSkuListBean = new ShopGoodsAddInfoVo.GoodsSkuListBean();
//
//                        //获取规格的分组名  (款式-长款;颜色-白色;尺码-M)
//                        String specNameStr = stringStringMap.get("specName");
//                        String[] specNameStrArr = specNameStr.split(";");
//
//                        //组装规格分类的Id
//                        List<Integer> fkSpecValueIdList = new ArrayList<>();
//                        for (int i = 0; i < specNameStrArr.length; i++) {
//                            String specNames = specNameStrArr[i];
//                            String[] specNamesArr = specNames.split("-");
//                            if(specNamesArr.length!=2){
//                                throw new IllegalArgumentException("商品规格格式错误");
//                            }
//                            String name = specNamesArr[0];
//                            String nameValue = specNamesArr[1];
//                            //根据规格值，查询id
//                            fkSpecValueIdList.add(12);
//                        }
//
//                        //填充规格分类的id
//                        goodsSkuListBean.setFkSpecValueIds(JSONUtil.toJsonStr(fkSpecValueIdList));
//                        goodsSkuListBean.setArtNo(stringStringMap.get("artNo"));
//                        goodsSkuListBean.setBarCode(stringStringMap.get("barCode"));
//
//                        //组装价格信息
//                        List<ShopGoodsAddInfoVo.GoodsSkuListBean.UnitPriceListBean> unitPriceList = new ArrayList<>();
//                        List<String> unitPriceStrList = new ArrayList<>();
//                        unitPriceStrList.add(stringStringMap.get("retailPrice"));
//                        unitPriceStrList.add(stringStringMap.get("wholesalePrice"));
//                        unitPriceStrList.add(stringStringMap.get("price1"));
//                        unitPriceStrList.add(stringStringMap.get("price2"));
//                        unitPriceStrList.add(stringStringMap.get("price3"));
//                        unitPriceStrList.add(stringStringMap.get("price4"));
//                        unitPriceStrList.add(stringStringMap.get("price5"));
//                        unitPriceStrList.add(stringStringMap.get("price6"));
//                        unitPriceStrList.forEach(new Consumer<String>() {
//                            @Override
//                            public void accept(String s) {
//                                if(s!=null&&!"".equals(s)){
//                                    unitList.forEach(new Consumer<ShopGoodsAddInfoVo.UnitListBean>() {
//                                        @Override
//                                        public void accept(ShopGoodsAddInfoVo.UnitListBean unitListBean) {
//                                            ShopGoodsAddInfoVo.GoodsSkuListBean.UnitPriceListBean unitPriceListBean = new ShopGoodsAddInfoVo.GoodsSkuListBean.UnitPriceListBean();
//                                            unitPriceListBean.setFkMemberPriceShopId(1);
//                                            unitPriceListBean.setPrice(changeY2F(Double.valueOf(s)*unitListBean.getAmount()));
//                                            unitPriceList.add(unitPriceListBean);
//                                        }
//                                    });
//                                }
//                            }
//                        });
//                        //填充单位价格
//                        goodsSkuListBean.setUnitPriceList(unitPriceList);
//
//                        //组装库存信息
//                        List<ShopGoodsAddInfoVo.GoodsSkuListBean.StoreListBean> storeList = new ArrayList<>();
//                        ShopGoodsAddInfoVo.GoodsSkuListBean.StoreListBean storeListBean = new ShopGoodsAddInfoVo.GoodsSkuListBean.StoreListBean();
//                        storeListBean.setWarehouseId(warehouseListBean.getFkWarehouseId());
//                        storeListBean.setStore(Double.valueOf(stringStringMap.get("store")).intValue());
//                        storeList.add(storeListBean);
//
//                        //填充库存信息
//                        goodsSkuListBean.setStoreList(storeList);
//
//                        goodsSkuList.add(goodsSkuListBean);
//                    });
//
//                    shopGoodsAddInfoVo.setUnitList(unitList);
//                    shopGoodsAddInfoVo.setGoodsSkuList(goodsSkuList);
//
//                    goodsAddInfoVoList.add(shopGoodsAddInfoVo);
//
//                }
//            });
//
//            System.out.println("商品数据============"+ JSONUtil.toJsonStr(goodsAddInfoVoList));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    /**
//     * 把单元格的内容转为字符串
//     * @param xssfCell 单元格
//     * @return 字符串
//     */
//    public static String getString(XSSFCell xssfCell) {
//        if (xssfCell == null) {
//            return "";
//        }
//        if (xssfCell.getCellTypeEnum() == CellType.NUMERIC) {
//            return String.valueOf(xssfCell.getNumericCellValue());
//        } else if (xssfCell.getCellTypeEnum() == CellType.BOOLEAN) {
//            return String.valueOf(xssfCell.getBooleanCellValue());
//        } else {
//            return xssfCell.getStringCellValue();
//        }
//    }
//
//
//    /**
//     * 元转分，确保price保留两位有效数字
//     * @return
//     */
//    public static int changeY2F(double price) {
//        DecimalFormat df = new DecimalFormat("#.00");
//        price = Double.valueOf(df.format(price));
//        int money = (int)(price * 100);
//        return money;
//    }
//
//}
