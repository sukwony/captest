import { WebPlugin } from '@capacitor/core'

import type { KakaoLoginPlugin } from './definitions'

export class KakaoLoginWeb extends WebPlugin implements KakaoLoginPlugin {
  async login (): Promise<{ accessToken: string }> {
    console.log('KakaoLogin')
    return { accessToken: 'bogusValue' }
  }
}
