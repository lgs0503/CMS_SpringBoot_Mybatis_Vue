import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AdminLoginView from '../views/admin/login/AdminLoginView.vue'
import AdminLayout from '../views/admin/layout/AdminLayout.vue'
import AdminHomeView from '../views/admin/home/AdminHomeView.vue'
import AdminCodeMgmtView from '../views/admin/code/AdminCodeMgmtView.vue'

const loginTokenCheck = () : string => {
  
  // 토큰 세션체크

  return "/admin/home";
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
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/admin/login',
      name: 'adminLogin',
      component: AdminLoginView
    },
    {
      path: '/admin',
      redirect : loginTokenCheck,
      component: AdminLayout,
      children: [
        {
          path: 'home',
          component: AdminHomeView
        },
        {
          path: 'code',
          component: AdminCodeMgmtView
        }
      ]
    }
  ]
})

export default router
