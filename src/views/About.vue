<template>
  <div class="container pull-to-refresh-ios">
    <div class="pull-to-refresh-ios__spinner">
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
      <div class="pull-to-refresh-ios__blade"></div>
    </div>
    <div class="about pull-to-refresh-ios__main">
      <h1>This is an about page</h1>
      <div class="view-about__buttons">
        <button @click="onClick">Google Login</button>
        <button @click="onClickKakaoLogin">Kakao Login</button>
        <button @click="onClickCallEchoPlugin">Call Echo Plugin</button>
        <button @click="onClickCheckVideo">Check Video</button>
        <button @click="onClickNicepay">Nicepay</button>
      </div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <video ref="video" src="https://d3n6mmqdzfby49.cloudfront.net/3/1/bvO-95HhTIyZt01ChBhD8A.m3u8" controls
        style="width: 12rem"
      ></video>
    </div>
  </div>
</template>

<script lang="ts">
import { Toast } from '@capacitor/toast'
import pullToRefresh from 'mobile-pull-to-refresh'
import ptrAnimatesIos from 'mobile-pull-to-refresh/dist/styles/ios/animates'
import 'mobile-pull-to-refresh/dist/styles/ios/style.css'
import { defineComponent } from 'vue'

import { Echo } from '@/plugins/echo'
import { KakaoLogin } from '@/plugins/kakao-login'
import { Nicepay } from '@/plugins/nicepay'
import GoogleAuth from '@/google'

export default defineComponent({
  data () {
    return {
      callback: () => undefined
    }
  },
  mounted () {
    this.callback = pullToRefresh({
      container: document.querySelector('.container'),
      animates: ptrAnimatesIos,

      refresh () {
        return new Promise(resolve => {
          setTimeout(resolve, 2000)
        })
      }
    })
  },
  beforeUnmount () {
    this.callback()
  },
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
