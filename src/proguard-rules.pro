# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.sumit.shimmerview.ShimmerView {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/sumit/shimmerview/repack'
-flattenpackagehierarchy
-dontpreverify
