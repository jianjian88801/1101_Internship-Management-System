import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import gonggao from '@/views/modules/gonggao/list'
    import laoshi from '@/views/modules/laoshi/list'
    import shixi from '@/views/modules/shixi/list'
    import shixiChengji from '@/views/modules/shixiChengji/list'
    import shixiFenxiang from '@/views/modules/shixiFenxiang/list'
    import shixiFenxiangCollection from '@/views/modules/shixiFenxiangCollection/list'
    import shixiFenxiangLiuyan from '@/views/modules/shixiFenxiangLiuyan/list'
    import shixiZhoubao from '@/views/modules/shixiZhoubao/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import config from '@/views/modules/config/list'
    import dictionaryBanji from '@/views/modules/dictionaryBanji/list'
    import dictionaryForum from '@/views/modules/dictionaryForum/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShixi from '@/views/modules/dictionaryShixi/list'
    import dictionaryShixiChengji from '@/views/modules/dictionaryShixiChengji/list'
    import dictionaryShixiFenxiang from '@/views/modules/dictionaryShixiFenxiang/list'
    import dictionaryShixiFenxiangCollection from '@/views/modules/dictionaryShixiFenxiangCollection/list'
    import dictionaryShixiYesno from '@/views/modules/dictionaryShixiYesno/list'
    import dictionaryShixiZhoubao from '@/views/modules/dictionaryShixiZhoubao/list'
    import dictionaryYuanxi from '@/views/modules/dictionaryYuanxi/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBanji',
        name: '班级',
        component: dictionaryBanji
    }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShixi',
        name: '单位性质',
        component: dictionaryShixi
    }
    ,{
        path: '/dictionaryShixiChengji',
        name: '成绩结果',
        component: dictionaryShixiChengji
    }
    ,{
        path: '/dictionaryShixiFenxiang',
        name: '分享类型',
        component: dictionaryShixiFenxiang
    }
    ,{
        path: '/dictionaryShixiFenxiangCollection',
        name: '收藏表类型',
        component: dictionaryShixiFenxiangCollection
    }
    ,{
        path: '/dictionaryShixiYesno',
        name: '审核状态',
        component: dictionaryShixiYesno
    }
    ,{
        path: '/dictionaryShixiZhoubao',
        name: '第几周',
        component: dictionaryShixiZhoubao
    }
    ,{
        path: '/dictionaryYuanxi',
        name: '院系',
        component: dictionaryYuanxi
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/laoshi',
        name: '老师',
        component: laoshi
      }
    ,{
        path: '/shixi',
        name: '实习',
        component: shixi
      }
    ,{
        path: '/shixiChengji',
        name: '实习成绩',
        component: shixiChengji
      }
    ,{
        path: '/shixiFenxiang',
        name: '实习分享',
        component: shixiFenxiang
      }
    ,{
        path: '/shixiFenxiangCollection',
        name: '实习分享收藏',
        component: shixiFenxiangCollection
      }
    ,{
        path: '/shixiFenxiangLiuyan',
        name: '实习分享留言',
        component: shixiFenxiangLiuyan
      }
    ,{
        path: '/shixiZhoubao',
        name: '实习周报',
        component: shixiZhoubao
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
