<template>  
        <el-container style="direction:horizontal">
            <el-header id="chooseLine">
                <span class="select" style="margin-top:10px">请选择地铁线路</span>       
                    <el-select v-model="value"  filterable placeholder="请选择线路" @change="changeTable" class="select">
                        <el-option v-for="item in options" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
                    </el-select>
            </el-header>
            
            <el-main>
            <el-table :data="lines"
                    stripe
                    border
                    style="width: 100%">
                <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" class="demo-table-expand">
                    <el-form-item label="线路名称">
                        <span>{{ props.row.lineName }}</span>
                        <el-input v-model="inputLineInfo.inputLineName" 
                                  placeholder="请输入修改的线路名"
                                  clearable></el-input>
                    </el-form-item>
                    <el-form-item label="起始站">
                        <span>{{ props.row.origin }}</span>
                        <el-input v-model="inputLineInfo.inputOrigin" 
                                  placeholder="请输入修改的起始站名"
                                  clearable></el-input>
                    </el-form-item>
                    <el-form-item label="终点站">
                        <span>{{ props.row.destination }}</span>
                        <el-input v-model="inputLineInfo.inputDestination" 
                                  placeholder="请输入修改的终点站名"
                                  clearable></el-input>
                    </el-form-item>
                    <el-form-item label="首班车">
                        <span>{{ props.row.startTime }}</span>
                        <el-input v-model="inputLineInfo.inputStartTime" 
                                  placeholder="请输入修改的首班车时间"
                                  clearable></el-input>
                    </el-form-item>
                    <el-form-item label="末班车">
                        <span>{{ props.row.endTime }}</span>
                        <el-input v-model="inputLineInfo.inputEndTime" 
                                  placeholder="请输入修改的末班车时间"
                                  clearable></el-input>
                    </el-form-item>
                    <el-form-item style="text-align:center">
                        <el-button type="primary" center="true" round>提交</el-button>
                    </el-form-item>
                    </el-form>
                    
                    
                </template>
                </el-table-column>
                <el-table-column prop="lineName" label="线路名称" ></el-table-column> 
                <el-table-column prop="origin" label="起始站" ></el-table-column>
                <el-table-column prop="destination" label="终点站"></el-table-column>
                <el-table-column prop="startTime" label="首班车" ></el-table-column>
                <el-table-column prop="endTime" label="末班车"></el-table-column>
                <el-table-column  label="操作" >
                        <el-button type="primary" icon="el-icon-edit" size="medium" @click="goToChangeLineInfo"></el-button> 
                </el-table-column>
            </el-table> 
            </el-main>
        
        </el-container>
</template>


<script>
import {postRequest} from '../utils/api'
import {putRequest} from '../utils/api'
import { stat } from 'fs';
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
            value: '',
            lines: [],
            inputLineInfo:{
                inputLineName: '',
                inputOrigin: '',
                inputDestination: '',
                inputStartTime: '',
                inputEndTime: ''
            }
        }
    },
    methods: {
        changeTable(lineName){
             this.$alert(lineName);
            var data = [];
            var obj = {};
            var _this = this;
            this.loading = true;
            postRequest('/lineInfo',lineName).then(resp=>{
                _this.loading = false;
                console.log(resp.data);
                if(resp.status == 200){
                    var json = resp.data;
                    for(let i = 0; i < json.length; i++){
                        obj.lineName = json[i].lineName;
                        obj.origin = json[i].origin;
                        obj.destination = json[i].destination;
                        obj.startTime = json[i].startTime;
                        obj.endTime = json[i].endTime;
                        data[i] = obj;
                    }
                    this.lines = data;
                }
            },resp=>{
                _this.loading = false;
                _this.$alert("无法找到该线路的信息");
            });
        }
    }
}
</script>


<style>

.select{
    padding: 20px; 
}

#chooseLine{
    background-color: white;
}

.demo-table-expand {
    font-size: 0;
}
.demo-table-expand label {
    width: 90px;
    color: #99a9bf;
}
.demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
}
</style>
