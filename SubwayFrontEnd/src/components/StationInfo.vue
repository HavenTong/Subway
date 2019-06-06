<template>
  <el-container style="direction:horizontal">
            <el-header id="chooseLine" height="80px">
                <span class="select" style="margin-top:10px">请选择地铁线路</span>       
                    <el-select  v-model="searchForm.searchLineName"  filterable placeholder="请选择线路" 
                                @change="changeTable(value)" class="select"
                                clearable="true">
                        <el-option v-for="item in options" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
                    </el-select>
                <span class="select" style="margin-top:10px">请输入地铁站名</span>
                <el-form id="stationSearch" model="searchForm" class="select" inline="true">
                        <el-form-item class="select">
                            <el-input v-model="searchForm.searchStationName"></el-input>
                        </el-form-item>
                        <el-button type="primary" round="true" class="select" @click="searchLineStation(searchForm)">查询</el-button>
                </el-form>
            </el-header>

            <el-main>
                <el-table :data="lineStation"
                          stripe="true"
                          border="true"
                          style="width:100%">
                          <el-table-column prop="lineName" label="线路名称"></el-table-column>
                          <el-table-column prop="origin" label="起始站"></el-table-column>
                          <el-table-column prop="stationName" label="停留站"></el-table-column>
                </el-table>
            </el-main>
            
  </el-container>



</template>



<script>
import {postRequest} from '../utils/api'
import {putRequest} from '../utils/api'
export default {
    data(){
        return {
            options:[{
                value: 1,
                label: '1号线'
            },{
                value: 2,
                label: '2号线'
            },{
                value: 3,
                label: '3号线'
            },{
                value: 4,
                label: '4号线'
            },{
                value: 5,
                label: '5号线'
            },{
                value: 6,
                label: '6号线'
            },{
                value: 7,
                label: '7号线'
            },{
                value: 8,
                label: '8号线'
            },{
                value: 9,
                label: '9号线'
            },{
                value: 10,
                label: '10号线'
            },{
                value: 11,
                label: '11号线'
            },{
                value: 12,
                label: '12号线'
            },{
                value: 13,
                label: '13号线'
            }],
            searchForm:{
                searchLineName:'',
                searchStationName:''
            },
            lineStation:[]
        };
    },
    methods:{
        searchLineStation(searchForm){
            this.loading = true;
            console.log(searchForm);
            postRequest('/stationInfo/searchStation',{
                lineName: searchForm.searchLineName,
                origin: '',
                stationName: searchForm.searchStationName
            }).then(resp=>{
                this.loading = false;
                console.log(resp.data);
                if(resp.status = 200){
                    var json = resp.data;
                    console.log(json.length);
                    this.lineStation = json;
                    console.log(this.lineStation);
                }
            }, resp=>{
                this.loading = false;
                this.$alert("无法找到该线路的站点信息");
            });
        }
    }
}
</script>


<style>
#chooseLine{
    background-color: white;
}

.select{
    margin-top: 20px;
}

#stationSearch{
    margin-left: -0;
}
</style>

