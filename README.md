# Shimmer View Extension

This extension is made for apply shimmer animation on any view component of the App Inventor.
This extension is much customizable than other ones.
In this extension you can run the shimmer effect in 4 direction. The four direction are
* Left To Right
* Right To Left
* Top To Bottom
* Bottom To Top

You can shape the shimmer effect or view with two shapes
* Linear
* Radial

## All Blocks

![IMG_20210714_101057](https://user-images.githubusercontent.com/74917290/125563119-c4e9fd69-1af9-4628-91b0-9e3e5d7ec1f0.jpg)

---

## Documentation

![component_event(3)](https://user-images.githubusercontent.com/74917290/125563211-f2c6ae39-f1f8-4396-ab3e-23acc2eff611.png)


This event raises when any error occured while working with shimmer.


![component_method(44)](https://user-images.githubusercontent.com/74917290/125563341-2002cf19-81c7-4c47-bb90-94aa0d33d95d.png)

This block do the main job that helps you create the shimmer view and apply it to the any view component of the app inventor.
It needs a view component in which you want to apply the shimmer and a unique id for customising it after creating it.

![component_method(45)](https://user-images.githubusercontent.com/74917290/125563584-958e2c82-dfe5-4f60-b019-04226d3efb00.png)

This block hides or invisble the shimmer from the view component.

![component_method(46)](https://user-images.githubusercontent.com/74917290/125563657-7f76b2a4-f42b-4510-b877-44f62778bfb3.png)

This block set the highlight color of the shimmer view mean the shimmer effect color



![component_method(47)](https://user-images.githubusercontent.com/74917290/125563762-009efaf2-82fa-4a5f-b857-cdcef2805a11.png)

This block returns the repeat delay duration of the shimmer view. Mean after the shimmer effect has ended then the duration in which it will reshown.

![component_method(48)](https://user-images.githubusercontent.com/74917290/125563769-474fafb0-f592-447e-9c32-46b6045348fa.png)

This block returns the animation of effect duration of the shimmer view.

![component_method(49)](https://user-images.githubusercontent.com/74917290/125563771-1c6e0ce8-27ef-4564-a760-2b0af8524983.png)

This block returns true if you have set the reverse mode to true by SetRepeat block.

![component_method(50)](https://user-images.githubusercontent.com/74917290/125563997-d2a4ab21-c0af-47e2-8248-2cf14c3c7112.png)

This block start the shimmer animation for given direction. There are 4 direction avaiable in this extension.


![component_method(51)](https://user-images.githubusercontent.com/74917290/125564008-fb6d03ef-2cb2-42e3-b581-1c5ee934af47.png)

This block stop the shimmer animation with given id.

![component_method(52)](https://user-images.githubusercontent.com/74917290/125564305-80ad6477-a512-405e-963b-0d8f4edf5064.png)

This block returns true if the shimmer is visible. You can hide it with Hide block.

![component_method(53)](https://user-images.githubusercontent.com/74917290/125564313-42efa4f4-d272-4a94-8c8d-b0b1caeadc3b.png)

This block returns the intensity or brightness of the shimmer view. You can set it with `SetIntensity` block.

![component_method(54)](https://user-images.githubusercontent.com/74917290/125564319-4a3fe2cc-4d98-40bf-bb9d-192e73e95058.png)

This block returns the degree in which the shimmer has been tilted. you can set the tilt degree with `SetTilt` block.

![component_method(55)](https://user-images.githubusercontent.com/74917290/125564323-be0ad94b-3a7b-4816-8884-c850c76574c9.png)

This bock set the shimmer color of the view. Mean it is the base color of the shimmer view. you can say this the background color of the shimmer view.

![component_method(66)](https://user-images.githubusercontent.com/74917290/125565134-1057d3a3-b116-400d-bfb1-7e005cd0194c.png)

This block return the shimmer effect otr highlight oolor woth given id.

![component_method(67)](https://user-images.githubusercontent.com/74917290/125565283-c58e671a-62c1-467a-8aed-21eb6700d430.png)

This block retuns the direction of the shimmer animation as String.


![component_method(65)](https://user-images.githubusercontent.com/74917290/125565139-cc551fae-5c10-460f-b783-755f9a4de574.png)

This block set the intensity of brightness of the shimmer effect. Larger intensity can cause the larger size of the shimmer view so use it logicly.

![component_method(64)](https://user-images.githubusercontent.com/74917290/125565140-5866d8a1-161d-4756-9acd-f90c6605955a.png)

Return true if the shimmer animation is started or the shimmer animation is running.

![component_method(63)](https://user-images.githubusercontent.com/74917290/125565146-c0b33a5a-24cf-4c48-9fe6-62a9f9326c05.png)

return the shimmer or base/background color of the shimmer effect for given id.

![component_method(62)](https://user-images.githubusercontent.com/74917290/125565147-42f84c6e-fb3d-4648-b82d-7a4317684544.png)

This block set the repeat property of the shimmer effect.

`repeatCount` means the times that the shimmer animation will be occured. Use -1 for infinite value.

`repeatDelay` means the time that taken by shimmer animation for reoccuring.

`reverse` if set to true then the animation will be reversed before restarting and if false then it will not be reversed it will directly restarted when the animation end.

![component_method(61)](https://user-images.githubusercontent.com/74917290/125565148-4833c42a-a55a-4bfd-98f4-782ddb3e52e6.png)

Return the shape of the shimmer effect. You can set it with `Set Shape` block.

![component_method(60)](https://user-images.githubusercontent.com/74917290/125565149-6bb10e9d-711b-4536-8df3-544f6d99b273.png)

This block returns the repeat count of the shimmer view for given id. it will return -1 if the count is set to INFINITE.

![component_method(59)](https://user-images.githubusercontent.com/74917290/125565151-e0d0faf0-7ab3-4072-9487-72d0a1977f23.png)

This block set the tilt degree if the shimmer view. If your degree amount is much then you should change the directon of the shimmer view instead of the seting the degree.

![component_method(58)](https://user-images.githubusercontent.com/74917290/125565154-e4db6251-312a-4a9f-84f3-70f6750046a4.png)

This block set the animation duration of the shimmer vivew or effect for given id.

![component_method(57)](https://user-images.githubusercontent.com/74917290/125565157-44191eaa-6f50-462a-8fd8-a0b1122f510f.png)

This block set the shape of the shape of the shimmer effect. There are two types of shapes available given above.

![image](https://user-images.githubusercontent.com/74917290/125568390-9b2a6b31-91dc-4d67-9f2a-ca7127d2f86c.png)

These are the 4 properties for defining the direction of the shimmer animation.

![image](https://user-images.githubusercontent.com/74917290/125568449-df69b3b6-a01f-4cfc-bb76-180f3c2808ed.png)

These are two property for defining the shape of the highlighted effect of the shimmer view.

---

## Usage

This extension is very easy to use. You have to guve a unique id and a layout in which you want to apply the shimmer. Then you can customize it accodring to you by different blocks so let see how we are making the shimmer

![blocks(21)](https://user-images.githubusercontent.com/74917290/125568756-c8f19cb7-5112-44fa-98f0-6b848663cad6.png)

---

## Preview

### Left to Right

https://github.com/Sumit1334/Shimmer-View/blob/main/assets/IMG_eh9pp0.gif


## Downloads

You can download the extension from the [out](https://github.com/Sumit1334/Shimmer-View/tree/main/out) folder of the main branch

## Compatbility
This extension is compatible with androidx and android support both libraries. You dont need to download any extra or different version for both libraries. Single extension will work in both.

## Contact

Contact <a href="https://community.kodular.io/u/sumit1334" target="_blank"> Sumit</a> for asking about this extension


