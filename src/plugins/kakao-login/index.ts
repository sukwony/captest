import { registerPlugin } from '@capacitor/core'

import type { KakaoLoginPlugin } from './definitions'

const KakaoLogin = registerPlugin<KakaoLoginPlugin>('KakaoLogin', {
  web: () => import('./web').then(m => new m.KakaoLoginWeb())
})

export { KakaoLogin }
