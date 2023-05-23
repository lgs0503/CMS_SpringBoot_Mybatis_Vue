import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AdminLoginView from '../views/admin/login/AdminLoginView.vue'
import AdminSignupView from '../views/admin/signup/AdminSignupView.vue'

import AdminLayout from '../views/admin/layout/AdminLayout.vue'

import AdminHomeView from '../views/admin/home/AdminHomeView.vue'

import AdminCodeMgmtView from '../views/admin/code/AdminCodeMgmtView.vue'
import AdminCodeMgmtDetailView from '../views/admin/code/AdminCodeMgmtDetailView.vue'

import AdminUserMgmtView from '../views/admin/user/AdminUserMgmtView.vue'
import AdminUserMgmtDetailView from  '../views/admin/user/AdminUserMgmtDetailView.vue'

import AdminRoleMgmtView from '../views/admin/role/AdminRoleMgmtView.vue'
import AdminRoleMgmtDetailView from  '../views/admin/role/AdminRoleMgmtDetailView.vue'

import AdminMenuMgmtView from '../views/admin/menu/AdminMenuMgmtView.vue'
import AdminMenuRoleMgmtView from '../views/admin/menuRole/AdminMenuRoleMgmtView.vue'
import AdminFileMgmtView from '../views/admin/file/AdminFileMgmtView.vue'

import AdminBoardMgmtView from '../views/admin/board/AdminBoardMgmtView.vue'
import AdminPostMgmtView from '../views/admin/post/AdminPostMgmtView.vue'
import AdminContentMgmtView from '../views/admin/content/AdminContentMgmtView.vue'
import AdminCommentMgmtView from '../views/admin/comment/AdminCommentMgmtView.vue'
import AdminLikeMgmtView from '../views/admin/like/AdminLikeMgmtView.vue'
import AdminBannerMgmtView from '../views/admin/banner/AdminBannerMgmtView.vue'
import AdminPopupMgmtView from '../views/admin/popup/AdminPopupMgmtView.vue'

import AdminFileUpDownHisView from '../views/admin/fileUpDownHis/AdminFileUpDownHisView.vue'
import AdminLoginHisView from '../views/admin/loginHis/AdminLoginHisView.vue'
import AdminMenuUseHisView from '../views/admin/menuUseHis/AdminMenuUseHisView.vue'

const loginTokenCheck = () : string => {

  const token = sessionStorage.getItem("loginToken");

  let redirectURL = "";

  if (token === null) {
    redirectURL = "/admin/login";
  } else {
    redirectURL = "/admin/home";
  }

  return redirectURL;
}

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/admin/login',
      name: 'adminLogin',
      component: AdminLoginView
    },
    {
      path: '/admin/signup',
      name: 'adminSignup',
      component: AdminSignupView
    },
    {
      path: '/admin',
      name: 'adminLayout',
      redirect : loginTokenCheck,
      component: AdminLayout,
      children: [
        {
          path: 'home',
          name: 'adminHome',
          component: AdminHomeView
        },
        {
          path: 'code',
          name: 'adminCode',
          component: AdminCodeMgmtView,
        },
        {
          path: 'code/:groupCodeId',
          name: 'adminCodeDetail',
          component: AdminCodeMgmtDetailView
        },
        {
          path: 'user',
          name: 'adminUser',
          component: AdminUserMgmtView
        },
        {
          path: 'user/:userNo',
          name: 'adminUserDetail',
          component: AdminUserMgmtDetailView
        },
        {
          path: 'role',
          name: 'adminRole',
          component: AdminRoleMgmtView
        },
        {
          path: 'role/:roleId',
          name: 'adminRoleDetail',
          component: AdminRoleMgmtDetailView
        },
        {
          path: 'menu',
          name: 'adminMenu',
          component: AdminMenuMgmtView
        },
        {
          path: 'menuRole',
          name: 'adminMenuRole',
          component: AdminMenuRoleMgmtView
        },
        {
          path: 'file',
          name: 'adminFile',
          component: AdminFileMgmtView
        },
        {
          path: 'board',
          name: 'adminBoard',
          component: AdminBoardMgmtView
        },
        {
          path: 'post',
          name: 'adminPost',
          component: AdminPostMgmtView
        },
        {
          path: 'content',
          name: 'adminContent',
          component: AdminContentMgmtView
        },
        {
          path: 'comment',
          name: 'adminComment',
          component: AdminCommentMgmtView
        },
        {
          path: 'like',
          name: 'adminLike',
          component: AdminLikeMgmtView
        },
        {
          path: 'banner',
          name: 'adminBanner',
          component: AdminBannerMgmtView
        },
        {
          path: 'popup',
          name: 'adminPopup',
          component: AdminPopupMgmtView
        },
        {
          path: 'loginHis',
          name: 'adminLoginHis',
          component: AdminLoginHisView
        },
        {
          path: 'fileUpDownHis',
          name: 'adminFileUpDownHis',
          component: AdminFileUpDownHisView
        },
        {
          path: 'menuUseHis',
          name: 'adminMenuUseHis',
          component: AdminMenuUseHisView
        }
      ]
    }
  ]
})

export default router
