import { createRouter, createWebHistory } from 'vue-router'

import { useAuthStore } from '../stores/auth'
import AdminLayout from '../layouts/AdminLayout.vue'
import DashboardView from '../views/dashboard/DashboardView.vue'
import BookCatalogView from '../views/library/BookCatalogView.vue'
import BorrowRecordView from '../views/library/BorrowRecordView.vue'
import LoginView from '../views/login/LoginView.vue'
import NoticeView from '../views/notices/NoticeView.vue'
import ReaderManagementView from '../views/library/ReaderManagementView.vue'
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
          path: 'library/books',
          name: 'library-books',
          component: BookCatalogView,
          meta: { title: 'Book Catalog' }
        },
        {
          path: 'library/readers',
          name: 'library-readers',
          component: ReaderManagementView,
          meta: { title: 'Reader Management' }
        },
        {
          path: 'library/borrow-records',
          name: 'library-borrow-records',
          component: BorrowRecordView,
          meta: { title: 'Borrow & Return' }
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
    document.title = `${to.meta.title} | Projectexample Library Management`
  }
})

export default router
