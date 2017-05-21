import Foundation
import CoreData

class DatabaseController
{
    
    private init(){
        
    }
    
    class func getContext() -> NSManagedObjectContext
    {
        return DatabaseController.persistentContainer.viewContext
    }
    
    // MARK: - Core Data stack
    
    static var persistentContainer: NSPersistentContainer = {
        
        let container = NSPersistentContainer(name: "HGSSmodel")
        container.loadPersistentStores(completionHandler: { (storeDescription, error) in
            if let error = error as NSError?
            {
                fatalError("Unresolved error \(error), \(error.userInfo)")
            }
        })
        return container
    }()
    
    // MARK: - Core Data Saving support
    
    class func saveContext ()
    {
        let context = persistentContainer.viewContext
        if context.hasChanges
        {
            do
            {
                try context.save()
            }
            catch
            {
                let nserror = error as NSError
                fatalError("Unresolved error \(nserror), \(nserror.userInfo)")
            }
        }
    }
    
    class func getUser(username: String) -> User
    {
        let userFetch = NSFetchRequest<NSFetchRequestResult>(entityName: Constants.userClassName)
        userFetch.predicate = NSPredicate(format: "username == %@", username)
        let result = try? DatabaseController.getContext().fetch(userFetch)
        if result?.count != 0
        {
            let resultData = result as! [User]
            let user = resultData[0]
            return user
        }
        else{
            let user = NSEntityDescription.insertNewObject(forEntityName: Constants.userClassName, into: DatabaseController.getContext()) as! User
            user.username = username
            DatabaseController.saveContext()
            return user
        }
    }

    
}

