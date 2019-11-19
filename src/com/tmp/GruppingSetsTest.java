package com.tmp;

import java.util.ArrayList;
import java.util.List;

public class GruppingSetsTest {

    private List<String> analyticsDimList = new ArrayList<String>();
    private List<String> mandatoryDimList = new ArrayList<String>();
    private List<String> hierarchyDimList = new ArrayList<String>();
    private List<String> jointDimList = new ArrayList<String>();
    private List<String> analyticsDimOrderList = new ArrayList<String>();
    private List<String> grouppingSetsList = new ArrayList<String>();

    public void addAnalyticsDim(String dim){
        analyticsDimList.add(dim);
    }

    public void addMandatoryDim(String dim){
        mandatoryDimList.add(dim);
    }


    public void addHierarchyDim(String dim){
        hierarchyDimList.add(dim);
    }

    public void addJointDim(String dim){
        jointDimList.add(dim);
    }

    public void analyticsDimOrder(){
        analyticsDimOrderList.clear();
        analyticsDimOrderList.addAll(mandatoryDimList);
        analyticsDimOrderList.addAll(hierarchyDimList);
        analyticsDimOrderList.addAll(jointDimList);
        for(int i=0;i<analyticsDimList.size();i++){
            if(!analyticsDimOrderList.contains(analyticsDimList.get(i))){
                analyticsDimOrderList.add(analyticsDimList.get(i));
            }
        }
    }


    public List<String> getAllGrouppingSetsList(int n){
        if(n>=(analyticsDimOrderList.size()-1)){
            List<String> grouppingSetsListTmp=new ArrayList<String>();
            grouppingSetsListTmp.add(analyticsDimOrderList.get(n));
            return grouppingSetsListTmp;
        }else{
            List<String> grouppingSetsList=new ArrayList<String>();
            List<String> beforeGrouppingSetsList=getAllGrouppingSetsList(n+1);
            grouppingSetsList.add(analyticsDimOrderList.get(n));
            for (int j=0;j<beforeGrouppingSetsList.size();j++){
                grouppingSetsList.add(analyticsDimOrderList.get(n)+","+beforeGrouppingSetsList.get(j));
            }
            if(n>0){
                grouppingSetsList.addAll(beforeGrouppingSetsList);
            }

            return grouppingSetsList;
        }
    }


    public boolean isTrue(String dim1,String dimCollect){
        boolean isTrue=true;
        String dim2=dimCollect.split(",")[0];
        if(hierarchyDimList.indexOf(dim2)>0){
            if(hierarchyDimList.get(hierarchyDimList.indexOf(dim2)-1).equals(dim1)){
                return true;
            }
        };

        if(jointDimList.indexOf(dim2)>0){
            if(!jointDimList.get(jointDimList.indexOf(dim2)-1).equals(dim1)){
                isTrue=true;
            };
        };
        return isTrue;
    }




    public static void main(String[] args){

        GruppingSetsTest test= new GruppingSetsTest();
        test.addAnalyticsDim("dt");
        test.addAnalyticsDim("platform_id,platform_name");
        test.addAnalyticsDim("termintal_id,termintal_name");
        test.addAnalyticsDim("client_id");
        test.addAnalyticsDim("city_level");
        test.addAnalyticsDim("city_id");
        test.addAnalyticsDim("appversion");
        test.addAnalyticsDim("aor_id");
        test.addAnalyticsDim("aor_type");


        test.analyticsDimOrder();
        System.out.println(test.analyticsDimList.indexOf(")"));
        List aaaa=test.getAllGrouppingSetsList(0);
        for(int i=0;i<aaaa.size();i++){
            System.out.println(aaaa.get(i));
        };

    }
}
