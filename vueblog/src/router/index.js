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
                path: '/LineInfo',
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
               path: 'LineInfo',
               name: '站点信息',
               iconCls: 'fa fa-arrow-circle-o-down',
               component: LineInfo
           }
       ]
    },{
        path: '/home',
        component: Home,
        name: '班次信息',
        children: [
            {
                path: 'LineInfo',
                name: '班次信息',
                iconCls: 'fa fa-bell',
                component: LineInfo
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
    },{
      path: '/home',
      component: Home,
      name: '文章管理',
      iconCls: 'fa fa-file-text-o',
      children: [
        {
          path: '/articleList',
          name: '文章列表',
          component: ArticleList,
          meta: {
            keepAlive: true
          }
        }, {
          path: '/postArticle',
          name: '发表文章',
          component: PostArticle,
          meta: {
            keepAlive: false
          }
        }, {
          path: '/blogDetail',
          name: '博客详情',
          component: BlogDetail,
          hidden: true,
          meta: {
            keepAlive: false
          }
        }, {
          path: '/editBlog',
          name: '编辑博客',
          component: PostArticle,
          hidden: true,
          meta: {
            keepAlive: false
          }
        }
      ]
    }, {
      path: '/home',
      component: Home,
      name: '栏目管理',
      children: [
        {
          path: '/cateMana',
          iconCls: 'fa fa-reorder',
          name: '栏目管理',
          component: CateMana
        }
      ]
    }
  ]
})
