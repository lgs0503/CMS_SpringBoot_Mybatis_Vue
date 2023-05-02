import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AdminLoginView from '../views/admin/login/AdminLoginView.vue'
import AdminSignupView from '../views/admin/signup/AdminSignupView.vue'
import AdminLayout from '../views/admin/layout/AdminLayout.vue'
import AdminHomeView from '../views/admin/home/AdminHomeView.vue'
import AdminCodeMgmtView from '../views/admin/code/AdminCodeMgmtView.vue'

const loginTokenCheck = () : string => {

  const token = sessionStorage.getItem("loginToken");
  console.log(token);

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
          component: AdminCodeMgmtView
        }
      ]
    }
  ]
})

export default router
