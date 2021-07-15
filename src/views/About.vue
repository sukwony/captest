<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div class="view-about__buttons">
      <button @click="onClick">Google Login</button>
      <button @click="onClickKakaoLogin">Kakao Login</button>
      <button @click="onClickCallEchoPlugin">Call Echo Plugin</button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

import { Toast } from '@capacitor/toast'
import { Echo } from '@/plugins/echo'
import { KakaoLogin } from '@/plugins/kakao-login'
import GoogleAuth from '@/google'

export default defineComponent({
  methods: {
    async onClick () {
      const response = await GoogleAuth.signIn()
      console.log(response)
    },
    async onClickKakaoLogin () {
      const { accessToken } = await KakaoLogin.login()
      console.log(28, accessToken)
      await Toast.show({ text: `Kakao accessToken: ${accessToken}` })
    },
    async onClickCallEchoPlugin () {
      const { value } = await Echo.echo({ value: 'Hello World' })
      await Toast.show({ text: `from plugin: ${value}` })
    }
  }
})
</script>

<style lang="scss" scoped>
.view-about {
  &__buttons {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
}
</style>
