export interface RestResponse<T> {
  success: boolean;
  payload: T;
  errorDescription: string;
}
