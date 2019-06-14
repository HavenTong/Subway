<template>
    <el-container style="direction:horizontal">
            <el-header class="header">
                <el-col :span="4">
                <span class="select" style="margin-top:10px"> <strong>请选择地铁线路</strong></span>  
                </el-col>   
                <el-col :span="6">
                    <el-select v-model="searchLineName"  filterable placeholder="请选择线路" @change="searchLineRuns(searchLineName)" class="select" clearable="true">
                        <el-option v-for="item in options" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
                    </el-select>
                </el-col>     
            </el-header>

            <el-main>
                <el-table :data="runs"
                          stripe="true"
                          border="true"
                          style="width:100%">
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="left" class="table-expand">
                            <el-form-item label="早高峰(7:30-9:30)"> 
                                <span>{{props.row.morningRushInterval}}</span>
                            </el-form-item>
                             <el-form-item label="平峰(9:30-17:00)">
                                <span>{{props.row.normalInterval}}</span>
                            </el-form-item>
                             <el-form-item label="晚高峰(17:00-19:30)">
                                <span>{{props.row.nightRushInterval}}</span>
                            </el-form-item>
                             <el-form-item label="其他时间">
                                <span>{{props.row.otherTimeInterval}}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column prop="runId" label="调度方案ID"></el-table-column>
                <el-table-column prop="lineName" label="线路名"></el-table-column>    
                <el-table-column prop="origin" label="起始站"></el-table-column>  
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button type="primary" icon="el-icon-edit" circle="true" @click="goToChangeRuns(scope.row)"></el-button>
                        <el-button type="danger" icon="el-icon-delete" circle="true" @click="deleteRun(scope.row)"></el-button>
                    </template>
                </el-table-column>
                </el-table>
                <el-dialog title="更改调度方案" :visible.sync="dialogFormVisble">
                    <el-form model="changeRunsForm">
                        <el-form-item label="调度方案ID">
                            <el-input clearable="true"
                                      disabled="true"
                                      v-model="changeRunsForm.runId"></el-input>
                        </el-form-item>
                        <el-form-item label="线路名">
                            <el-input clearable="true"
                                      disabled="true"
                                      v-model="changeRunsForm.lineName"></el-input>
                        </el-form-item>
                        <el-form-item label="起始站">
                            <el-input clearable="true"
                                      disabled="true"
                                      v-model="changeRunsForm.origin"></el-input>
                        </el-form-item>
                        <el-form-item label="早高峰(7:30-9:30)">
                            <el-input clearable="true"
                                      v-model="changeRunsForm.morningRushInterval"></el-input>
                        </el-form-item>
                        <el-form-item label="平峰(9:30-17:00)">
                            <el-input clearable="true"
                                      v-model="changeRunsForm.normalInterval"></el-input>
                        </el-form-item>
                        <el-form-item label="晚高峰(17:00-19:30)">
                            <el-input clearable="true"
                                      v-model="changeRunsForm.nightRushInterval"></el-input>
                        </el-form-item>
                        <el-form-item label="其他时间">
                            <el-input clearable="true" v-model="changeRunsForm.otherTimeInterval">
                            </el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" round="true" @click="changeRun(changeRunsForm)">提交</el-button>
                        </el-form-item>
                    </el-form>
                </el-dialog>
            </el-main>

            <el-header class="header">
                <el-col span="4">
                    <span class="select" style="margin-top:10px"><strong>新增调度方案</strong></span>
                </el-col>
            </el-header>
            <el-main>
                <el-form :model="insertRunsForm" label-width="250px">
                    <el-form-item label="线路名">
                        <el-col span="300px">
                        <el-input v-model="insertRunsForm.insertLineName" class="newRunsForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="起始站">
                        <el-col span="300px">
                        <el-input v-model="insertRunsForm.insertOrigin" class="newRunsForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="早高峰(7:30-9:30)">
                        <el-col span="300px">
                            <el-input v-model="insertRunsForm.insertMorningRushInterval" class="newRunsForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="平峰(9:30-17:00)">
                        <el-col span="300px">
                            <el-input v-model="insertRunsForm.insertNormalInterval" class="newRunsForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="晚高峰(17:00-19:30)">
                        <el-col span="300px">
                        <el-input v-model="insertRunsForm.insertNightRushInterval" class="newRunsForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="其他时间">
                        <el-col span="300px">
                        <el-input v-model="insertRunsForm.insertOtherTimeInterval" class="newRunsForm" clearable="true"></el-input>
                        </el-col>
                    </el-form-item>
                    <el-form-item style="margin-right:175px">
                        <el-button type="primary" round="true" @click="insertNewRun(insertRunsForm)">提交</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
    </el-container>
</template>



<script>
import {postRequest} from '../utils/api'
import {putRequest} from '../utils/api'
export default {
    data() {
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
            searchLineName:'',
            runs:[],
            insertRunsForm:{
                insertLineName:'',
                insertOrigin:'',
                insertMorningRushInterval:'',
                insertNormalInterval:'',
                insertNightRushInterval:'',
                insertOtherTimeInterval:''
            },
            dialogFormVisble:false,
            changeRunsForm:{
                runId:0,
                lineName:'',
                origin:'',
                morningRushInterval:'',
                normalInterval:'',
                nightRushInterval:'',
                otherTimeInterval:''
            }

        }
    },

    methods:{
        searchLineRuns(searchLineName){
            this.loading = true;
            postRequest('/run/searchRun',{
                lineName: searchLineName
            }).then(resp=>{
                this.loading = false;
                console.log(resp.data);
                if(resp.status == 200){
                    var json = resp.data;
                    this.runs = json;
                    console.log(this.runs);
                }
            }, resp=>{
                this.loading = false;
                this.$alert("无法找到该线路的班次");
            })
        },

        goToChangeRuns(changeRunsLine){
            this.dialogFormVisble = true;
            this.changeRunsForm = changeRunsLine;
        },

        changeRun(changeRunsForm){
            this.loading = true;
            postRequest('/run/changeRun',{
                runId: changeRunsForm.runId,
                lineName: changeRunsForm.lineName,
                origin: changeRunsForm.origin,
                morningRushInterval: changeRunsForm.morningRushInterval,
                normalInterval: changeRunsForm.normalInterval,
                nightRushInterval: changeRunsForm.nightRushInterval,
                otherTimeInterval: changeRunsForm.otherTimeInterval
            }).then(resp=>{
                this.loading = false;
                console.log(resp.data);
                if(resp.status == 200 && resp.data != 0){
                    this.$alert("更新成功");
                }else{
                    this.$alert("更新失败，输入数据格式不正确");
                }
            }, resp=>{
                this.loading = false;
                this.$alert("更新失败，数据未成功传输到服务器");
            });
        },

        insertNewRun(insertRunsForm){
            this.loading = true;
            console.log(insertRunsForm)
            postRequest('/run/insertNewRun', {
                runId:0,
                lineName: insertRunsForm.insertLineName,
                origin: insertRunsForm.insertOrigin,
                morningRushInterval: insertRunsForm.insertMorningRushInterval,
                normalInterval: insertRunsForm.insertNormalInterval,
                nightRushInterval: insertRunsForm.insertNightRushInterval,
                otherTimeInterval: insertRunsForm.insertOtherTimeInterval
            }).then(resp=>{
                this.loading = false;
                if(resp.status == 200 && resp.data != 0){
                    this.$alert("成功新增调度方案");
                }else{
                    this.$alert("新增调度方案失败，请按格式输入");
                }
            }, resp=>{
                this.loading = false;
                this.$alert("与服务器失去连接");
            });
        },

        deleteRun(deleteRunsLine){
            console.log(deleteRunsLine);
            this.$confirm('此操作将永久删除该调度方案, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.loading = true;
                console.log(deleteRunsLine);
                postRequest('/run/deleteRun',{
                    runId: deleteRunsLine.runId
                }).then(resp=>{
                    this.loading = false;
                    if(resp.status == 200 && resp.data != 0){
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    }
                })  
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });          
            });
        }
    }
    
}
</script>

<style>
.select{
    padding: 20px; 
}
.header{
    background-color: white;
}

.newRunsForm{
    margin-left: 100px
}

.table-expand {
    font-size: 0;
}

.table-expand{
    width: 90px;
    color: #99a9bf;
  }
.table-expand {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
}

</style>

