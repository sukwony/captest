import { registerPlugin } from '@capacitor/core'

import type { NaverLoginPlugin } from './definitions'

const NaverLogin = registerPlugin<NaverLoginPlugin>('NaverLogin', {
  web: () => import('./web').then(m => new m.NaverLoginWeb())
})

export { NaverLogin }
