<template>  
        <el-container>
            <el-header>
                <span class="select" style="margin-top:10px">请选择地铁线路</span>       
                    <el-select v-model="value"  filterable placeholder="请选择线路" @change="getValue" class="select">
                        <el-option v-for="item in options" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.value">
                        </el-option>
                    </el-select>
            </el-header>

            <el-table :data="lines"
                    stripe
                    style="width: 100%">
                <el-table-column prop="name" label="线路名称" width="100"></el-table-column>
                <el-table-column prop="station" label="起始站" width="100"></el-table-column>
            </el-table> 
        
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
            value: '',
            lines: [{
                name: '1',
                station: 'jinshajianglu' 
            },{
                name: '2',
                station: 'zhongshanbeilu'
            }]
        }
    },
    methods: {
        getvalue(value){
            this.$alert(value);
        }
    }
}
</script>


<style>

.select{
    padding: 20px; 
}

</style>
