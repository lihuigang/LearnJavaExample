package com.tmp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GruppingSetsTest {

    private static String DELETE_DIM="deleteDims";

    private LinkedList<String> analyticsDimList = new LinkedList<>();

    private List<List<String>> hierarchyDimAllList = new ArrayList<List<String>>();


    public void addAnalyticsDim(String dim){
        analyticsDimList.add(dim);
    }

    public void addMandatoryDims(List<String> dimList){

        String dimsTmp="";
        for(int i=0;i<dimList.size();i++){
            if("".equals(dimsTmp)){
                dimsTmp+=dimList.get(i);
            }else{
                dimsTmp+=",";
                dimsTmp+=dimList.get(i);
            }
        }
        analyticsDimList.removeAll(dimList);
        analyticsDimList.add(0,dimsTmp);
    }


    public void addHierarchyDim(List<String> dimList){

        hierarchyDimAllList.add(dimList);
        analyticsDimList.removeAll(dimList);
        analyticsDimList.addAll(dimList);
    }


    public void addJointDims(List<String> dimList){

        String dimsTmp="";
        for(int i=0;i<dimList.size();i++){
            if("".equals(dimsTmp)){
                dimsTmp+=dimList.get(i);
            }else{
                dimsTmp+=",";
                dimsTmp+=dimList.get(i);
            }
        }
        System.out.println(dimsTmp);
        this.analyticsDimList.removeAll(dimList);
        this.analyticsDimList.add(dimsTmp);
    }






    public List<String> getAllGrouppingSetsList(int n){
        List<String> deleteDimRowList=new ArrayList<String>();
        deleteDimRowList.add(DELETE_DIM);
        if(n>=(analyticsDimList.size()-1)){
            List<String> grouppingSetsListTmp=new ArrayList<String>();
            grouppingSetsListTmp.add(analyticsDimList.get(n));
            return grouppingSetsListTmp;
        }else{
            List<String> grouppingSetsList=new ArrayList<String>();
            List<String> beforeGrouppingSetsList=getAllGrouppingSetsList(n+1);
            grouppingSetsList.add(analyticsDimList.get(n));
            for (int j=0;j<beforeGrouppingSetsList.size();j++){
                    String currentDim= analyticsDimList.get(n);
                    String beforeDim=beforeGrouppingSetsList.get(j);
                    grouppingSetsList.add(currentDim + "," + beforeDim);
                    if(isHierarchyDim(currentDim,beforeDim)){
                        beforeGrouppingSetsList.set(j,DELETE_DIM);
                    }
            }
            beforeGrouppingSetsList.removeAll(deleteDimRowList);

            if(n>0){
                grouppingSetsList.addAll(beforeGrouppingSetsList);
            }
            return grouppingSetsList;
        }
    }


    public boolean isHierarchyDim(String dim1,String dimCollect) {
        String dim2 = dimCollect.split(",")[0];
        for(int i=0;i<hierarchyDimAllList.size();i++){
            List<String> hierarchyDimList=hierarchyDimAllList.get(i);
            if (hierarchyDimList.indexOf(dim2) > 0 && hierarchyDimList.get(hierarchyDimList.indexOf(dim2) - 1).equals(dim1)) {
                return  true;
            }
            return false;
        }
        return false;
    }





    public static void main(String[] args){


        List<String> jointDimList=new ArrayList<>();
        List<String> mandatorydimList1=new ArrayList<>();
        List<String> jointDimList1=new ArrayList<>();
        List<String> hierarchyDimList1 = new ArrayList<>();
        List<String> hierarchyDimList2 = new ArrayList<>();
        GruppingSetsTest test= new GruppingSetsTest();
        test.addAnalyticsDim("dt");
        test.addAnalyticsDim("entry_id|entry_name");
        test.addAnalyticsDim("platform_id|platform_name");
        test.addAnalyticsDim("termintal_id|termintal_name");
        test.addAnalyticsDim("client_id|client_name");
        test.addAnalyticsDim("city_level");
        test.addAnalyticsDim("city_id|city_name");
        test.addAnalyticsDim("appversion");
        test.addAnalyticsDim("aor_id");
        test.addAnalyticsDim("aor_type");

        mandatorydimList1.add("dt");
        mandatorydimList1.add("entry_id|entry_name");
        hierarchyDimList2.add("aor_id");
        hierarchyDimList2.add("aor_type");

        jointDimList1.add("city_level");
        jointDimList1.add("city_id|city_name");


        hierarchyDimList1.add("platform_id|platform_name");
        hierarchyDimList1.add("termintal_id|termintal_name");
        hierarchyDimList1.add("client_id|client_name");

        //test.addJointDims(jointDimList);
        test.addJointDims(jointDimList1);
        test.addMandatoryDims(mandatorydimList1);

        test.addHierarchyDim(hierarchyDimList1);
        test.addHierarchyDim(hierarchyDimList2);


        List aaaa=test.getAllGrouppingSetsList(0);
        for(int i=0;i<aaaa.size();i++){
            String dims=aaaa.get(i).toString();
            System.out.println("("+dims.replace("|",",")+")");
        };

    }
}
