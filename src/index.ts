// import {
//   NativeModulesProxy,
//   EventEmitter,
//   Subscription,
// } from "expo-modules-core";

// Import the native module. On web, it will be resolved to MyModule.web.ts
// and on native platforms to MyModule.ts
import MyModule from "./MyModule";
import { ChangeEventPayload, MyModuleViewProps } from "./MyModule.types";

export async function pickPhoto() {
  return await MyModule.pickPhoto();
}

// const emitter = new EventEmitter(MyModule ?? NativeModulesProxy.MyModule);

// export function addChangeListener(
//   listener: (event: ChangeEventPayload) => void
// ): Subscription {
//   return emitter.addListener<ChangeEventPayload>("onChange", listener);
// }

export { MyModuleViewProps, ChangeEventPayload };
