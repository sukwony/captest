import { WebPlugin } from '@capacitor/core'

import type { NicepayPlugin } from './definitions'

export class NicepayWeb extends WebPlugin implements NicepayPlugin {
  async bring (): Promise<void> {
    console.log('7')
  }
}
