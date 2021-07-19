import { registerPlugin } from '@capacitor/core'

import type { NicepayPlugin } from './definitions'

const Nicepay = registerPlugin<NicepayPlugin>('Nicepay', {
  web: () => import('./web').then(m => new m.NicepayWeb())
})

export { Nicepay }
