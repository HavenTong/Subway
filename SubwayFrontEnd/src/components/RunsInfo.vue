<template>
    <el-container style="direction:horizontal">
            <el-header class="header">
                <el-col :span="4">
                <span class="select" style="margin-top:10px"> <strong>请选择地铁线路</strong></span>  
                </el-col>   
                <el-col :span="6">
                    <el-select v-model="value"  filterable placeholder="请选择线路" @change="changeTable(value)" class="select">
                        <el-option v-for="item in options" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
                    </el-select>
                </el-col>
                <el-col :span="4">
                <span class="select" style="margin-top:10px"> <strong>请选择时间段</strong></span>  
                </el-col> 
                <el-col :span="4">
                    <el-select v-model="value"  filterable placeholder="请选择线路" @change="changeTable(value)" class="select">
                        <el-option v-for="item in options" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
                    </el-select>
                </el-col>
                <el-col :span="1">--</el-col>
                <el-col :span="4">
                    <el-select v-model="value"  filterable placeholder="请选择线路" @change="changeTable(value)" class="select">
                        <el-option v-for="item in options" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
                    </el-select>
                </el-col>     
            </el-header>
    </el-container>
</template>



<script>
import {postRequest} from '../utils/api'
import {putRequest} from '../utils/api'
export default {
    methods:{
        test:function(){
            alert("Success");
        }
    },
    data() {
        return {
            status: "success"
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
</style>

