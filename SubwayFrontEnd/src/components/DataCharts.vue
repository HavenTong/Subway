<template>
  <el-container>
      <el-header class="header">
          <el-col span="6">
              <span class="select" style="margin-top:10px"><strong>请选择日期和时间段</strong></span>
          </el-col>
          <el-col span="6">
              <el-select  v-model="searchTimeIntervalForm.date"  filterable placeholder="请选择日期" 
                                 class="select" clearable="true">
                        <el-option v-for="item in dateOptions" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
              </el-select>
          </el-col>
          <el-col span="6">
              <el-select  v-model="searchTimeIntervalForm.startTime"  filterable placeholder="请选择起始时间" 
                                 class="select" clearable="true">
                        <el-option v-for="item in timeOptions" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
              </el-select>
          </el-col>
          <el-col span="6">
              <el-select  v-model="searchTimeIntervalForm.endTime"  filterable placeholder="请选择起始时间" 
                                 class="select" clearable="true">
                        <el-option v-for="item in timeOptions" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
              </el-select>
          </el-col>
          <el-col span="6">
              <el-button type="primary" round="true" @click="searchStationPopulation(searchTimeIntervalForm)">查询</el-button>
          </el-col>
      </el-header>
      <el-main>
        <div style="display: flex;height: 500px;width: 100%;align-items: center;justify-content: center;">
            <chart ref="dschart" :options="polar" style="margin-top: 20px"></chart>
        </div>
      </el-main>

      <el-header class="header">
          <el-col span="6">
              <span class="select" style="margin-top:10px"><strong>请选择日期并输入站点</strong></span>
          </el-col>
          <el-col span="6">
              <el-select  v-model="searchStationForm.date"  filterable placeholder="请选择日期" 
                                 class="select" clearable="true">
                        <el-option v-for="item in dateOptions" 
                                :key="item.value" 
                                :label="item.label" 
                                :value="item.label">
                        </el-option>
              </el-select>
          </el-col>
          <el-col span="6">
            <el-form>
              <el-form-item>
                  <el-input v-model="searchStationForm.stationName"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
      </el-header>

  </el-container>
</template>

<style>
</style>
<script>
  import ECharts from 'vue-echarts/components/ECharts.vue'
  import 'echarts/lib/chart/line'
  import 'echarts/lib/chart/bar'
  import 'echarts/lib/component/tooltip'

  import 'echarts/lib/component/polar'

  import 'echarts/lib/component/legend'
  import 'echarts/lib/component/title'
  import 'echarts/theme/dark'
  import 'echarts/lib/chart/bar'

  import {getRequest, postRequest} from '../utils/api'
  export default{
    components: {
      'chart': ECharts
    },
    // mounted: function () {
    //   var _this = this;
    //   getRequest("/article/dataStatistics").then(resp=> {
    //     if (resp.status == 200) {
    //       _this.$refs.dschart.options.xAxis.data = resp.data.categories;
    //       _this.$refs.dschart.options.series[0].data = resp.data.ds;
    //     } else {
    //       _this.$message({type: 'error', message: '数据加载失败!'});
    //     }
    //   }, resp=> {
    //     _this.$message({type: 'error', message: '数据加载失败!'});
    //   });
    // },
    data(){
      return {
        polar: {
          title: {
            text: '当前时间段人流量TOP7站点',
            left: 'left'
          },
          toolbox: {
            show: true,
            feature: {
              dataZoom: {
                yAxisIndex: 'none'
              },
              dataView: {
                readOnly: false
              },
              magicType: {
                type: ['line', 'bar']
              },
              restore: {},
              saveAsImage: {}
            }
          },
          tooltip: {
              trigger:'axis'
          },
          legend: {
            data: ['人流量']
          },
          xAxis: {
            data: [],
            axisLabel:{
                interval:0
            }
          },
          yAxis: {},
          series: [{
            name: '人流量',
            type: 'bar',
            data: [],
            markPoint:{
                data:[
                    {type:'max', name:'最大值'}
                ]
            },
            markLine:{
                data:[
                    {type:'average', name:'平均值'}
                ]
            }
          }],
          animationDuration: 3000
        },

        dateOptions:[{
            value:1,
            label:'2016-07-01'
        },{
            value:2,
            label:'2016-07-02'
        },{
            value:3,
            label:'2016-07-03'
        },{
            value:4,
            label:'2016-07-04'
        },{
            value:5,
            label:'2016-07-05'
        }
        ],

        searchTimeIntervalForm:{
            date:'',
            startTime:'',
            endTime:''
        },

        searchStationForm:{
            stationName:'',
            date:''
        },

        timeOptions:[{
            value:1,
            label:'07:00:00'
        },{
            value:2,
            label:'08:00:00'
        },{
            value:3,
            label:'09:00:00'
        },{
            value:4,
            label:'10:00:00'
        },{
            value:5,
            label:'11:00:00'
        },{
            value:6,
            label:'12:00:00'
        },{
            value:7,
            label:'13:00:00'
        },{
            value:8,
            label:'14:00:00'
        },{
            value:9,
            label:'15:00:00'
        },{
            value:10,
            label:'16:00:00'
        },{
            value:11,
            label:'17:00:00'
        },{
            value:12,
            label:'18:00:00'
        },{
            value:13,
            label:'19:00:00'
        },{
            value:14,
            label:'20:00:00'
        },{
            value:15,
            label:'21:00:00'
        },{
            value:16,
            label:'22:00:00'
        },{
            value:17,
            label:'23:00:00'
        }]
      };
    },

    methods:{
        searchStationPopulation(searchTimeIntervalForm){
            this.loading = true;
            console.log(searchTimeIntervalForm);
            postRequest('/dataStatistic/stationPopulation',{
                date:searchTimeIntervalForm.date,
                startTime: searchTimeIntervalForm.startTime,
                endTime:searchTimeIntervalForm.endTime
            }).then(resp=>{
                this.loading = false;
                console.log(resp.data);
                if(resp.status == 200){
                    var resultsForGraph = resp.data;
                    // this.$alert(resultsForGraph.result);
                    this.$refs.dschart.options.xAxis.data = resultsForGraph.stations;
                    this.$refs.dschart.options.series[0].data = resultsForGraph.stationPopulation;
                }
            }, resp=>{
                this.loading = false;
                this.$alert("Failure");
            });
        }
    },
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

