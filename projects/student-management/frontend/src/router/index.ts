import { createRouter, createWebHistory } from 'vue-router'

import { useAuthStore } from '../stores/auth'
import AdminLayout from '../layouts/AdminLayout.vue'
import DashboardView from '../views/dashboard/DashboardView.vue'
import LoginView from '../views/login/LoginView.vue'
import NoticeView from '../views/notices/NoticeView.vue'
import ClassManagementView from '../views/student/ClassManagementView.vue'
import DisciplineRecordView from '../views/student/DisciplineRecordView.vue'
import ScoreManagementView from '../views/student/ScoreManagementView.vue'
import StudentArchiveView from '../views/student/StudentArchiveView.vue'
import MenuView from '../views/system/MenuView.vue'
import RoleView from '../views/system/RoleView.vue'
import UserView from '../views/system/UserView.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      meta: { title: 'Login' }
    },
    {
      path: '/',
      component: AdminLayout,
      meta: { requiresAuth: true },
      children: [
        {
          path: '',
          redirect: '/dashboard'
        },
        {
          path: 'dashboard',
          name: 'dashboard',
          component: DashboardView,
          meta: { title: 'Dashboard' }
        },
        {
          path: 'system/users',
          name: 'system-users',
          component: UserView,
          meta: { title: 'Users' }
        },
        {
          path: 'system/roles',
          name: 'system-roles',
          component: RoleView,
          meta: { title: 'Roles' }
        },
        {
          path: 'system/menus',
          name: 'system-menus',
          component: MenuView,
          meta: { title: 'Menus' }
        },
        {
          path: 'notices',
          name: 'notices',
          component: NoticeView,
          meta: { title: 'Notices' }
        },
        {
          path: 'student/archives',
          name: 'student-archives',
          component: StudentArchiveView,
          meta: { title: 'Student Archive' }
        },
        {
          path: 'student/classes',
          name: 'student-classes',
          component: ClassManagementView,
          meta: { title: 'Class & Major' }
        },
        {
          path: 'student/scores',
          name: 'student-scores',
          component: ScoreManagementView,
          meta: { title: 'Scores' }
        },
        {
          path: 'student/discipline-records',
          name: 'student-discipline-records',
          component: DisciplineRecordView,
          meta: { title: 'Leave & Discipline' }
        }
      ]
    }
  ]
})

router.beforeEach(async (to) => {
  const authStore = useAuthStore()
  if (!authStore.initialized) {
    await authStore.bootstrap()
  }

  if (to.meta.requiresAuth && !authStore.isAuthenticated) {
    return { path: '/login', query: { redirect: to.fullPath } }
  }

  if (to.path === '/login' && authStore.isAuthenticated) {
    return '/dashboard'
  }

  if (typeof to.meta.title === 'string') {
    document.title = `${to.meta.title} | Projectexample Student Management`
  }
})

export default router
