import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/login.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/register.vue')
    },
    {
      path: '/habilities',
      name: 'habilities',
      component: () => import('../views/habilities.vue')
    },
    {
      path: '/reporte',
      name: 'reporte',
      component: () => import('../views/reporte.vue')
    }
  ]
})

export default router
