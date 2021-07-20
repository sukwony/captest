export interface NaverLoginPlugin {
  login(): Promise<{ accessToken: string }>
}
