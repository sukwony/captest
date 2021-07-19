<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div class="view-about__buttons">
      <button @click="onClick">Google Login</button>
      <button @click="onClickKakaoLogin">Kakao Login</button>
      <button @click="onClickCallEchoPlugin">Call Echo Plugin</button>
      <button @click="onClickCheckVideo">Check Video</button>
      <button @click="onClickNicepay">Nicepay</button>
    </div>
    <video ref="video" src="https://d3n6mmqdzfby49.cloudfront.net/3/1/bvO-95HhTIyZt01ChBhD8A.m3u8" controls
      style="width: 5rem"
    ></video>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

import { Toast } from '@capacitor/toast'
import { Echo } from '@/plugins/echo'
import { KakaoLogin } from '@/plugins/kakao-login'
import { Nicepay } from '@/plugins/nicepay'
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
    },
    async onClickCheckVideo () {
      const video = this.$refs.video as HTMLMediaElement
      const canPlay = video.canPlayType('application/vnd.apple.mpegurl')
      console.log(40, canPlay)
      await Toast.show({ text: `can play? ${canPlay}` })
    },
    async onClickNicepay () {
      await Nicepay.bring()
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
