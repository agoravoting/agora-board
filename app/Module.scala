import com.google.inject.AbstractModule
import java.time.Clock
import models.Backend
import services.FiwareBackend

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.

 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
class Module extends AbstractModule {

  override def configure() = {
    // Set FiwareBackend as the implementation for Backend.
    bind(classOf[Backend]).to(classOf[FiwareBackend])
    // Ask Guice to create an instance of FiwareBackend when the
    // application starts, reducing latency on the first Backend call
    bind(classOf[FiwareBackend]).asEagerSingleton
  }

}
