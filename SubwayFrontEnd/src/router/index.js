// 路由，将vue文件导入，建立路由表
import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import ArticleList from '@/components/ArticleList'
import CateMana from '@/components/CateMana'
import DataCharts from '@/components/DataCharts'
import PostArticle from '@/components/PostArticle'
import UserMana from '@/components/UserMana'
import BlogDetail from '@/components/BlogDetail'
import LineInfo from '@/components/LineInfo'
import StationInfo from '@/components/StationInfo'
import RunsInfo from '@/components/RunsInfo'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '登录',
      hidden: true,
      component: Login
    }, {
      path: '/home',
      name: '',
      component: Home,
      hidden: true
    }, {
        path: '/home',
        component: Home,
        name: '线路信息',
        children: [
            {
                path: '/lineInfo',
                iconCls: 'fa fa-subway',
                name: '线路信息',
                component: LineInfo
            }
        ]
    },{
       path: '/home',
       component: Home,
       name: '站点信息',
       children: [
           {
               path: '/stationInfo',
               name: '站点信息',
               iconCls: 'fa fa-arrow-circle-o-down',
               component: StationInfo
           }
       ]
    },{
        path: '/home',
        component: Home,
        name: '班次信息',
        children: [
            {
                path: '/runsInfo',
                name: '班次信息',
                iconCls: 'fa fa-bell',
                component: RunsInfo
            }
        ]
    }, {
        path: '/home',
        component: Home,
        name: '数据统计',
        iconCls: 'fa fa-bar-chart',
        children: [
            {
                path: '/charts',
                iconCls: 'fa fa-bar-chart',
                name: '数据统计',
                component: DataCharts
            }
        ]
    },{
        path: '/home',
        component: Home,
        name: '用户管理',
        children: [
            {
                path: '/user',
                iconCls: 'fa fa-user-circle-o',
                name: '用户管理',
                component: UserMana
            }
        ]
    }
  ]
})
