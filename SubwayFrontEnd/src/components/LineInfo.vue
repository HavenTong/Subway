<template>  
        <el-container style="direction:horizontal">
            <el-header class="header">
                <span class="select" style="margin-top:10px"> <strong>请选择地铁线路</strong></span>       
                    <el-select v-model="value"  filterable placeholder="请选择线路" @change="changeTable(value)" class="select">
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
                <el-table-column prop="lineName" label="线路名称" ></el-table-column> 
                <el-table-column prop="origin" label="起始站" ></el-table-column>
                <el-table-column prop="destination" label="终点站"></el-table-column>
                <el-table-column prop="startTime" label="首班车" ></el-table-column>
                <el-table-column prop="endTime" label="末班车"></el-table-column>
                <el-table-column  label="操作" >
                    <template slot-scope="scope">
                        <el-button type="primary" icon="el-icon-edit" size="medium" @click="goToChangeLineInfo(scope.row)"></el-button> 
                    </template>
                </el-table-column>  
            </el-table> 
            <el-dialog title="更改线路信息" :visible.sync="dialogFormVisble">
                    <el-form model="inputLineInfo">
                        <el-form-item label="线路名">
                            <el-input disabled="true"
                                      :clearable="true"
                                      v-model="inputLineInfo.lineName"></el-input>
                        </el-form-item>
                        <el-form-item label="起始站">
                            <el-input disabled="true"
                                      clearable="true"
                                      v-model="inputLineInfo.origin"></el-input>
                        </el-form-item>
                        <el-form-item label="终点站">
                            <el-input  disabled="true"
                                       clearable="true"
                                       v-model="inputLineInfo.destination"></el-input>
                        </el-form-item>
                        <el-form-item label="首班车">
                            <el-input clearable="true"
                                      v-model="inputLineInfo.startTime"></el-input>
                        </el-form-item>
                        <el-form-item label="末班车">
                            <el-input clearable="true"
                                      v-model="inputLineInfo.endTime"></el-input>
                        </el-form-item>
                        <el-button type="primary" center="true" round="true" @click="submitLineInfo(inputLineInfo)">提交</el-button>
                    </el-form>
            </el-dialog>  
            </el-main>

            <el-header class="header">
                <span class="select"><strong>新增线路</strong></span>
            </el-header>
            <el-main>
                <el-form :model="newLineInfo" label-width="250px" ref="newLineInfo">
                    <el-form-item label="线路名称" prop="lineName">
                        <el-col span="300px">
                        <el-input v-model="newLineInfo.lineName" class="newLineForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="起始站" prop="origin">
                        <el-col span="300px">
                        <el-input v-model="newLineInfo.origin" class="newLineForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="终点站" prop="destination">
                        <el-col span="300px">
                        <el-input v-model="newLineInfo.destination" class="newLineForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="首班车" prop="startTime">
                        <el-col span="300px">
                        <el-input v-model="newLineInfo.startTime" class="newLineForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="末班车" prop="endTime">
                        <el-col span="300px">
                        <el-input v-model="newLineInfo.endTime" class="newLineForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item style="margin-right:175px">
                        <el-button type="primary" round="true" @click="insertNewLine(newLineInfo)">提交</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
        </el-container>
</template>


<script>
import {postRequest} from '../utils/api'
import {putRequest} from '../utils/api'
import { stat, link, copyFileSync } from 'fs';
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
            dialogFormVisble: false,
            inputLineInfo:{
                lineName: '',
                origin: '',
                destination: '',
                startTime: '',
                endTime: ''
            },
            newLineInfo:{
                lineName: '',
                origin: '',
                destination: '',
                startTime: '',
                endTime: ''
            }
            
        };
    },
    methods: {
        changeTable(searchLineName){
            // this.$alert(searchLineName);
            var data = [];
            var obj = {};
            var _this = this;
            this.loading = true;
            postRequest('/lineInfo/',{
                lineName: searchLineName
            }).then(resp=>{
                _this.loading = false;
                console.log(resp.data);
                if(resp.status == 200){
                    var json = resp.data;
                    console.log(json.length);
                    this.lines = json;
                    console.log(_this.lines);
                }
            },resp=>{
                _this.loading = false;
                _this.$alert("无法找到该线路的信息");
            });
        },

        goToChangeLineInfo(rowLineInfo){
            this.dialogFormVisble = true;
            this.inputLineInfo = rowLineInfo;
        },

        submitLineInfo(inputLineInfo){
            this.dialogFormVisble = false;
            console.log(inputLineInfo);
            this.loading = true;
            postRequest('/lineInfo/changeInfo',{
                lineName: inputLineInfo.lineName,
                origin: inputLineInfo.origin,
                destination: inputLineInfo.destination,
                startTime: inputLineInfo.startTime,
                endTime: inputLineInfo.endTime
            }).then(
                resp =>{
                    this.loading = false;
                    if(resp.status == 200){
                        this.$alert("修改成功");
                    }
                },resp=>{
                    this.loading = false;
                    this.$alert("修改失败");
                }
            );
        },

        insertNewLine(newLineInfo){
            console.log(newLineInfo);
            this.loading = true;
            postRequest('/lineInfo/insertLine',{
                lineName:newLineInfo.lineName,
                origin:newLineInfo.origin,
                destination:newLineInfo.destination,
                startTime:newLineInfo.startTime,
                endTime:newLineInfo.endTime
            }).then(resp=>{
                this.loading = false;
                if(resp.status == 200){
                    var result = resp.data
                    if(result == 'success'){
                        this.newLineInfo.lineName = '';
                        this.newLineInfo.origin = '';
                        this.newLineInfo.destination = '';
                        this.newLineInfo.startTime = '';
                        this.newLineInfo.endTime = '';
                        this.$alert("添加成功!请前往“站点信息”添加中间停靠站");
                    }
                }
            }, resp=>{
                this.loading = false;
                this.$alert("新增线路失败");
            })
        }
    }
};
</script>


<style>

.select{
    padding: 20px; 
}

.newLineForm{
    margin-left: 100px
}

.header{
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
