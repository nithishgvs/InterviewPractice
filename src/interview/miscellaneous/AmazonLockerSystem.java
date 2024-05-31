package interview.miscellaneous;


import java.util.*;

class Locker {

  private String id;
  private boolean isAvailable;
  private String packageId; // ID of the package currently in the locker

  public Locker(String id) {
    this.id = id;
    this.isAvailable = true;
    this.packageId = null;
  }

  public String getId() {
    return id;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void assignPackage(String packageId) {
    this.packageId = packageId;
    this.isAvailable = false;
  }

  public void releaseLocker() {
    this.packageId = null;
    this.isAvailable = true;
  }
}

class LockerManager {

  private Map<String, Locker> lockers;

  public LockerManager() {
    lockers = new HashMap<>();
  }

  public void addLocker(String id) {
    lockers.put(id, new Locker(id));
  }

  public void removeLocker(String id) {
    lockers.remove(id);
  }

  public Locker findAvailableLocker() {
    for (Locker locker : lockers.values()) {
      if (locker.isAvailable()) {
        return locker;
      }
    }
    return null; // No available lockers
  }

  public boolean assignLockerToPackage(String packageId) {
    Locker availableLocker = findAvailableLocker();
    if (availableLocker != null) {
      availableLocker.assignPackage(packageId);
      return true;
    }
    return false; // No available lockers
  }

  public boolean releaseLocker(String lockerId) {
    Locker locker = lockers.get(lockerId);
    if (locker != null && !locker.isAvailable()) {
      locker.releaseLocker();
      return true;
    }
    return false; // Locker not found or already available
  }

  public Map<String, Locker> getLockers() {
    return lockers;
  }
}

class AdminInterface {

  private LockerManager lockerManager;

  public AdminInterface(LockerManager lockerManager) {
    this.lockerManager = lockerManager;
  }

  public void addLocker(String id) {
    lockerManager.addLocker(id);
    System.out.println("Locker " + id + " added.");
  }

  public void removeLocker(String id) {
    lockerManager.removeLocker(id);
    System.out.println("Locker " + id + " removed.");
  }
}

public class AmazonLockerSystem {

  public static void main(String[] args) {
    LockerManager lockerManager = new LockerManager();
    AdminInterface adminInterface = new AdminInterface(lockerManager);

    // Admin adds lockers
    adminInterface.addLocker("L1");
    adminInterface.addLocker("L2");

    // Find available locker and assign package
    if (lockerManager.assignLockerToPackage("P123")) {
      System.out.println("Package P123 assigned to a locker.");
    } else {
      System.out.println("No available lockers.");
    }

    // Release locker
    if (lockerManager.releaseLocker("L1")) {
      System.out.println("Locker L1 released.");
    } else {
      System.out.println("Locker L1 not found or already available.");
    }
  }
}


