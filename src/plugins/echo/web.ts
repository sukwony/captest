import { WebPlugin } from '@capacitor/core'

import type { EchoPlugin } from './definitions'

export class EchoWeb extends WebPlugin implements EchoPlugin {
  async echo (options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options)
    return options
  }
}
