#import "RCTBridgeModule.h"
#import "HumanConnectViewController.h"
#import <UIKit/UIKit.h>

//@interface HumanReactModule : NSObject<RCTBridgeModule>
@interface HumanReactModule : UIViewController <HumanAPINotifications, RCTBridgeModule>


@end
