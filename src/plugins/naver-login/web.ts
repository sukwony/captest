import { WebPlugin } from '@capacitor/core'

import type { NaverLoginPlugin } from './definitions'

export class NaverLoginWeb extends WebPlugin implements NaverLoginPlugin {
  async login (): Promise<{ accessToken: string }> {
    console.log('NaverLogin')
    return { accessToken: 'bogusValue' }
  }
}
