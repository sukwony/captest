export interface KakaoLoginPlugin {
  login(): Promise<{ accessToken: string }>
}
