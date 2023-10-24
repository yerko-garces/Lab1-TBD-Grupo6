import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/prelogin.vue' //cambiar

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'preLogin',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/login.vue')
    },
    {
      path: '/loginInstitucion',
      name: 'loginInstitucion',
      component: () => import('../views/loginInstitucion.vue')
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
      path: '/registerInstitucion',
      name: 'registerInstitucion',
      component: () => import('../views/registerInstitucion.vue')
    },
    {
      path: '/habilities',
      name: 'habilities',
      component: () => import('../views/habilities.vue')
    },
    {
      path: '/vistaInstitucion',
      name: 'vistaInstitucion',
      component: () => import('../views/vistaInstitucion.vue')
    },
    {
      path: '/catastrofes',
      name: 'catastrofes',
      component: () => import('../views/catastrofes.vue')
    },
    {
      path: '/miPerfil',
      name: 'miPerfil',
      component: () => import('../views/miPerfil.vue')
    },
    {
      path: '/mostrarPrerequisitos',
      name: 'mostrarPrerequisitos',
      component: () => import('../views/mostrarPrerequisitos.vue')
    }
  ]
})

export default router
