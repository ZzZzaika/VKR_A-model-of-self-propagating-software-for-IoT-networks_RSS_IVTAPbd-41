package diploma;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;
import com.anylogic.engine.omniverse_connector.*;

import com.anylogic.libraries.modules.markup_descriptors.*;
import com.anylogic.libraries.processmodeling.*;

import java.awt.geom.Arc2D;

public class Main extends Agent
{
  // Parameters

  /**
   * Интервал повторного сканирования сети заражённым устройством.
   */
  public 
double  rzero;

  /**
   * Returns default value for parameter <code>rzero</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _rzero_DefaultValue_xjal() {
    final Main self = this;
    return 
1.5 
;
  }

  public void set_rzero( double value ) {
    if (value == this.rzero) {
      return;
    }
    double _oldValue_xjal = this.rzero;
    this.rzero = value;
    onChange_rzero_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter rzero.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_rzero()</code> method instead.
   */
  protected void onChange_rzero() {
    onChange_rzero_xjal( rzero );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_rzero_xjal( double oldValue ) {
	int index;
    index = 0;
    for ( Virus self : viruses ) {
      
      double _value;
      _value = rzero
;
      self.set_rzeroScore( _value );
      index++;
    }  
  }


  /**
   * Базовый коэффициент репродукции (сколько устройств заражает один инфицированный).
   */
  public 
double  scanInterval;

  /**
   * Returns default value for parameter <code>scanInterval</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _scanInterval_DefaultValue_xjal() {
    final Main self = this;
    return 
5.0 
;
  }

  public void set_scanInterval( double value ) {
    if (value == this.scanInterval) {
      return;
    }
    double _oldValue_xjal = this.scanInterval;
    this.scanInterval = value;
    onChange_scanInterval_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter scanInterval.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_scanInterval()</code> method instead.
   */
  protected void onChange_scanInterval() {
    onChange_scanInterval_xjal( scanInterval );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_scanInterval_xjal( double oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    rzero = _rzero_DefaultValue_xjal();
    scanInterval = _scanInterval_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "rzero":
      if ( _callOnChange_xjal ) {
        set_rzero( ((Number) _value_xjal).doubleValue() );
      } else {
        rzero = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "scanInterval":
      if ( _callOnChange_xjal ) {
        set_scanInterval( ((Number) _value_xjal).doubleValue() );
      } else {
        scanInterval = ((Number) _value_xjal).doubleValue();
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "rzero": _result_xjal = rzero; break;
    case "scanInterval": _result_xjal = scanInterval; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "rzero" );
      list.add( "scanInterval" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  /**
   * Целевое устройство для очередного создаваемого червя.
   */
  public 
IoTDevice 
 pendingVirusTarget;
  /**
   * R0 очередного червя.
   */
  public 
double 
 pendingVirusRZero;
  /**
   * Целевое устройство для очередного создаваемого патча.
   */
  public 
IoTDevice 
 pendingPatchTarget;
  /**
   * Последний червь, успешно проверивший возможность заражения; используется для передачи в becomeExposed.
   */
  public 
Virus 
 lastInfectingVirus;
  /**
   * Латентный период по умолчанию (в минутах).
   */
  public 
double 
 defaultLatencyPeriod;
  /**
   * Политика смены пароля после лечения: "bruteforce" (только после перебора) или "always".
   */
  public 
String 
 passwordChangeMode;
  /**
   * Список конфигураций устройств, загружаемый через GUI/JSON.
   */
  public 
java.util.ArrayList<DeviceConfig> 
 configs;
  /**
   * Массив изолированных подсетей.
   */
  public 
ArrayList<String> 
 isolatedSegments;
  /**
   * Флаг автоматической изоляции заражённых подсетей.
   */
  public 
boolean 
 autoIsolation;
  /**
   * Словарь логинов и паролей для атаки перебором (строки вида "login:password").
   */
  public 
ArrayList<String> 
 passwordDictionary;
  /**
   * Режим атаки: "bruteforce", "exploit", "combined".
   */
  public 
String 
 attackMode;
  /**
   * Имя устройства, с которого начнётся заражение (если пусто – выбирается случайно).
   */
  public 
String 
 patientZeroName;
  /**
   * Среднее время обнаружения заражения (в минутах).
   */
  public 
double 
 timeToDetect;
  /**
   * Среднее время принятия решения сисадмина (в минутах).
   */
  public 
double 
 timeToRespond;
  /**
   * Среднее время для разработки патча (в минутах).
   */
  public 
double 
 timeToDevelopPatch;
  /**
   * Среднее время для развёртывания патча (в секундах).
   */
  public 
double 
 timeToDeploy;
  /**
   * Метка времени первого заражения (инициализируется как –1, используется для запуска обнаружения).
   */
  public 
double 
 firstInfectionTime;
  /**
   * Скорость сети в Мбит/с, влияет на задержки передачи червей/патчей.
   */
  public 
double 
 networkSpeed;

  // Collection Variables
  public 
ArrayList <
IoTDevice > virusTargets = new ArrayList<IoTDevice>();
  public 
LinkedList <
Double > virusRZero = new LinkedList<Double>();
  public 
ArrayList <
IoTDevice > patchTargets = new ArrayList<IoTDevice>();

  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Main.class );

  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 50.0 );

  @Override
  public Scale getScale() {
    return scale;
  }


  // Events

  public EventTimeout processVirusQueue = new EventTimeout(this);
  public EventTimeout detectionEvent = new EventTimeout(this);
  public EventTimeout responseEvent = new EventTimeout(this);
  public EventTimeout developEvent = new EventTimeout(this);
  public EventTimeout deployEvent = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == processVirusQueue ) return "processVirusQueue";
     if( _e == detectionEvent ) return "detectionEvent";
     if( _e == responseEvent ) return "responseEvent";
     if( _e == developEvent ) return "developEvent";
     if( _e == deployEvent ) return "deployEvent";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == processVirusQueue ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == detectionEvent ) return EVENT_TIMEOUT_MODE_ONCE;
    if ( _e == responseEvent ) return EVENT_TIMEOUT_MODE_ONCE;
    if ( _e == developEvent ) return EVENT_TIMEOUT_MODE_ONCE;
    if ( _e == deployEvent ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == processVirusQueue ) {
      _t = 
0.05 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if ( _e == detectionEvent ) {
      _t = 
timeToDetect 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    if ( _e == responseEvent ) {
      _t = 
timeToRespond 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    if ( _e == developEvent ) {
      _t = 
timeToDevelopPatch 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    if ( _e == deployEvent ) {
      _t = 
timeToDeploy 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == processVirusQueue) {
      _t = 
1 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if( _e == deployEvent) {
      _t = 
timeToDeploy 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == processVirusQueue ) {
      EventTimeout self = _e;

if (virusTargets.size() > 0) {
	IoTDevice target = virusTargets.get(0);

	if (target.inState(IoTDevice.Infected)
			|| target.inState(IoTDevice.Exposed)
			|| target.inState(IoTDevice.Recovered)) {
		virusTargets.remove(0);
		virusRZero.remove(0);
		return;
	}

	pendingVirusTarget = virusTargets.remove(0);
	pendingVirusRZero = virusRZero.remove(0);
	sourceVirus.inject(1);
} 
;
      return;
    }
    if ( _e == detectionEvent ) {
      EventTimeout self = _e;

traceln("[" + time() + "] ИНЦИДЕНТ ОБНАРУЖЕН!");
if (autoIsolation) {
	for (IoTDevice d : devices) {
		if (d.inState(IoTDevice.Infected)
				&& d.segment != null && !d.segment.isEmpty()
				&& !isolatedSegments.contains(d.segment)) {
			isolatedSegments.add(d.segment);
			traceln("[" + time()
					+ "] Автоизоляция: подсеть '"
					+ d.segment + "' изолирована");
		}
	}
}
responseEvent.restart(timeToRespond, MINUTE); 
;
      return;
    }
    if ( _e == responseEvent ) {
      EventTimeout self = _e;

traceln("[" + time()
		+ "] Принято решение о разработке патча.");
developEvent.restart(timeToDevelopPatch, MINUTE); 
;
      return;
    }
    if ( _e == developEvent ) {
      EventTimeout self = _e;

traceln("[" + time()
		+ "] Патч разработан. Начинаем развёртывание.");
for (IoTDevice d : devices) {
	if (d.inState(IoTDevice.Infected)
			|| d.inState(IoTDevice.Exposed)) {
		patchTargets.add(d);
	}
}
if (!deployEvent.isActive()) {
	deployEvent.restart(timeToDeploy, SECOND);
} 
;
      return;
    }
    if ( _e == deployEvent ) {
      EventTimeout self = _e;

if (patchTargets.size() > 0) {
	IoTDevice target = patchTargets.remove(0);
	createPatch(target);
} else {
	deployEvent.reset();
	traceln("[" + time()
			+ "] Все доступные устройства пролечены.");
} 
;
      return;
    }
    super.executeActionOf( _e );
  }


  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _viruses_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _patches_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _devices_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public com.anylogic.libraries.processmodeling.MoveTo<
Virus 
> virusMove;
  public com.anylogic.libraries.processmodeling.Delay<
Virus 
> virusDelay;
  public com.anylogic.libraries.processmodeling.Sink<
Virus 
> virusSink;
  public com.anylogic.libraries.processmodeling.Source<
Virus 
> sourceVirus;
  public com.anylogic.libraries.processmodeling.MoveTo<
Patch 
> patchMove;
  public com.anylogic.libraries.processmodeling.Delay<
Patch 
> patchDelay;
  public com.anylogic.libraries.processmodeling.Sink<
Patch 
> patchSink;
  public com.anylogic.libraries.processmodeling.Source<
Patch 
> sourcePatch;

  public String getNameOf( Agent ao ) {
    if ( ao == virusMove ) return "virusMove";
    if ( ao == virusDelay ) return "virusDelay";
    if ( ao == virusSink ) return "virusSink";
    if ( ao == sourceVirus ) return "sourceVirus";
    if ( ao == patchMove ) return "patchMove";
    if ( ao == patchDelay ) return "patchDelay";
    if ( ao == patchSink ) return "patchSink";
    if ( ao == sourcePatch ) return "sourcePatch";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }

  public class _viruses_Population extends AgentArrayList<Virus> {
    _viruses_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public Virus instantiateAgent( int index ) {
    	return instantiate_viruses_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( Virus agent, int index, TableInput tableInput ) {
      setupParameters_viruses_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( Virus agent, int index, TableInput tableInput ) {
      doBeforeCreate_viruses_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "Virus")
  public _viruses_Population viruses = new _viruses_Population( this );
  public class _patches_Population extends AgentArrayList<Patch> {
    _patches_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public Patch instantiateAgent( int index ) {
    	return instantiate_patches_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( Patch agent, int index, TableInput tableInput ) {
      setupParameters_patches_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( Patch agent, int index, TableInput tableInput ) {
      doBeforeCreate_patches_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "Patch")
  public _patches_Population patches = new _patches_Population( this );
  public class _devices_Population extends AgentArrayList<IoTDevice> {
    _devices_Population( Agent owner ) {
      super( owner );
    }


    @AnyLogicInternalCodegenAPI
    public IoTDevice instantiateAgent( int index ) {
    	return instantiate_devices_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( IoTDevice agent, int index, TableInput tableInput ) {
      setupParameters_devices_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( IoTDevice agent, int index, TableInput tableInput ) {
      doBeforeCreate_devices_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "IoTDevice")
  public _devices_Population devices = new _devices_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == viruses ) return "viruses";
    if( aolist == patches ) return "patches";
    if( aolist == devices ) return "devices";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    if( aolist == viruses ) return _viruses_animationSettings_xjal;
    if( aolist == patches ) return _patches_animationSettings_xjal;
    if( aolist == devices ) return _devices_animationSettings_xjal;
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in viruses
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public Virus viruses(int index) {
    return viruses.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection viruses<br>
   * @return newly created embedded object
   */
  public Virus add_viruses() {
    int index = viruses.size();
    Virus _result_xjal = instantiate_viruses_xjal( index );
    viruses.callSetupParameters( _result_xjal, index );
    viruses.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection viruses<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>viruses.size()</code> method <strong>before</strong> this method is called
   * @param rzeroScore
   * @param targetDevice
   * @return newly created embedded object
   */
  public Virus add_viruses( double rzeroScore, IoTDevice targetDevice ) {
    int index = viruses.size();
    Virus _result_xjal = instantiate_viruses_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.rzeroScore = rzeroScore;
    _result_xjal.targetDevice = targetDevice;
    // Finish embedded object creation
    viruses.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection viruses<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object viruses - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to viruses
   */
  public boolean remove_viruses( Virus object ) {
    if( ! viruses._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in patches
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public Patch patches(int index) {
    return patches.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection patches<br>
   * @return newly created embedded object
   */
  public Patch add_patches() {
    int index = patches.size();
    Patch _result_xjal = instantiate_patches_xjal( index );
    patches.callSetupParameters( _result_xjal, index );
    patches.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection patches<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>patches.size()</code> method <strong>before</strong> this method is called
   * @param targetDevice
   * @return newly created embedded object
   */
  public Patch add_patches( IoTDevice targetDevice ) {
    int index = patches.size();
    Patch _result_xjal = instantiate_patches_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.targetDevice = targetDevice;
    // Finish embedded object creation
    patches.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection patches<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object patches - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to patches
   */
  public boolean remove_patches( Patch object ) {
    if( ! patches._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }
  /**
   * Returns the agent element at the specified position in devices
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public IoTDevice devices(int index) {
    return devices.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection devices<br>
   * @return newly created embedded object
   */
  public IoTDevice add_devices() {
    int index = devices.size();
    IoTDevice _result_xjal = instantiate_devices_xjal( index );
    devices.callSetupParameters( _result_xjal, index );
    devices.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection devices<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>devices.size()</code> method <strong>before</strong> this method is called
   * @param cvssScore
   * @param deviceName
   * @return newly created embedded object
   */
  public IoTDevice add_devices( double cvssScore, String deviceName ) {
    int index = devices.size();
    IoTDevice _result_xjal = instantiate_devices_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.cvssScore = cvssScore;
    _result_xjal.deviceName = deviceName;
    // Finish embedded object creation
    devices.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection devices<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object devices - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to devices
   */
  public boolean remove_devices( IoTDevice object ) {
    if( ! devices._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    object.removeUsdObjects();
    return true;
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Virus instantiate_viruses_xjal( final int index ) {
    Virus _result_xjal = new Virus( getEngine(), this, viruses );
    
    viruses._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_viruses_xjal( final Virus self, final int index, TableInput _t ) {
    self.rzeroScore = 
rzero 
;
    self.targetDevice = self._targetDevice_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_viruses_xjal( Virus self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 860.0
;
double _y_xjal = 460.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.MoveTo<Virus> instantiate_virusMove_xjal() {
    com.anylogic.libraries.processmodeling.MoveTo<Virus> _result_xjal = new com.anylogic.libraries.processmodeling.MoveTo<Virus>( getEngine(), this, null ) {
      @Override
      public Agent destinationAgent( Virus agent ) {
        return _virusMove_destinationAgent_xjal( this, agent );
      }
      @Override
      public boolean setSpeed( Virus agent ) {
        return _virusMove_setSpeed_xjal( this, agent );
      }
      @Override
      public double speed( Virus agent ) {
        return _virusMove_speed_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_speed() {
        return MPS;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_virusMove_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Virus> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.destinationType = 
self.DEST_AGENT 
;
    self.destinationInNetwork = self._destinationInNetwork_DefaultValue_xjal();
    self.useOffsets = self._useOffsets_DefaultValue_xjal();
    self.straightMovement = self._straightMovement_DefaultValue_xjal();
    self.destinationUseRotation = self._destinationUseRotation_DefaultValue_xjal();
    self.restoreSpeedOnArrival = self._restoreSpeedOnArrival_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_virusMove_xjal( com.anylogic.libraries.processmodeling.MoveTo<Virus> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Delay<Virus> instantiate_virusDelay_xjal() {
    com.anylogic.libraries.processmodeling.Delay<Virus> _result_xjal = new com.anylogic.libraries.processmodeling.Delay<Virus>( getEngine(), this, null ) {
      @Override
      public double delayTime( Virus agent ) {
        return _virusDelay_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_virusDelay_xjal( final com.anylogic.libraries.processmodeling.Delay<Virus> self, TableInput _t ) {
    self.type = self._type_DefaultValue_xjal();
    self.capacity = 
100 
;
    self.maximumCapacity = self._maximumCapacity_DefaultValue_xjal();
    self.entityLocation = self._entityLocation_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
    self.restoreEntityLocationOnExit = self._restoreEntityLocationOnExit_DefaultValue_xjal();
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_virusDelay_xjal( com.anylogic.libraries.processmodeling.Delay<Virus> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Sink<Virus> instantiate_virusSink_xjal() {
    com.anylogic.libraries.processmodeling.Sink<Virus> _result_xjal = new com.anylogic.libraries.processmodeling.Sink<Virus>( getEngine(), this, null ) {
      @Override
      public void onEnter( Virus agent ) {
        _virusSink_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_virusSink_xjal( final com.anylogic.libraries.processmodeling.Sink<Virus> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_virusSink_xjal( com.anylogic.libraries.processmodeling.Sink<Virus> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Source<Virus> instantiate_sourceVirus_xjal() {
    com.anylogic.libraries.processmodeling.Source<Virus> _result_xjal = new com.anylogic.libraries.processmodeling.Source<Virus>( getEngine(), this, null ) {
      @Override
      public INode locationNode( Virus agent ) {
        return _sourceVirus_locationNode_xjal( this, agent );
      }
      @Override
      public Agent newEntity(  ) {
        return _sourceVirus_newEntity_xjal( this );
      }
      @Override
      public void onExit( Virus agent ) {
        _sourceVirus_onExit_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_sourceVirus_xjal( final com.anylogic.libraries.processmodeling.Source<Virus> self, TableInput _t ) {
    self.arrivalType = 
self.MANUAL 
;
    self.rate = self._rate_DefaultValue_xjal();
    self.firstArrivalMode = self._firstArrivalMode_DefaultValue_xjal();
    self.firstArrivalTime = self._firstArrivalTime_DefaultValue_xjal();
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.multipleEntitiesPerArrival = self._multipleEntitiesPerArrival_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.locationType = 
self.LOCATION_NODE 
;
    self.locationXYZInNetwork = self._locationXYZInNetwork_DefaultValue_xjal();
    self.enableCustomStartTime = self._enableCustomStartTime_DefaultValue_xjal();
    self.startTime = self._startTime_DefaultValue_xjal();
    self.addToCustomPopulation = self._addToCustomPopulation_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
    self.discardHangingEntities = self._discardHangingEntities_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_sourceVirus_xjal( com.anylogic.libraries.processmodeling.Source<Virus> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.MoveTo<Patch> instantiate_patchMove_xjal() {
    com.anylogic.libraries.processmodeling.MoveTo<Patch> _result_xjal = new com.anylogic.libraries.processmodeling.MoveTo<Patch>( getEngine(), this, null ) {
      @Override
      public Agent destinationAgent( Patch agent ) {
        return _patchMove_destinationAgent_xjal( this, agent );
      }
      @Override
      public boolean setSpeed( Patch agent ) {
        return _patchMove_setSpeed_xjal( this, agent );
      }
      @Override
      public double speed( Patch agent ) {
        return _patchMove_speed_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_speed() {
        return MPS;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_patchMove_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Patch> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.destinationType = 
self.DEST_AGENT 
;
    self.destinationInNetwork = self._destinationInNetwork_DefaultValue_xjal();
    self.useOffsets = self._useOffsets_DefaultValue_xjal();
    self.straightMovement = self._straightMovement_DefaultValue_xjal();
    self.destinationUseRotation = self._destinationUseRotation_DefaultValue_xjal();
    self.restoreSpeedOnArrival = self._restoreSpeedOnArrival_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_patchMove_xjal( com.anylogic.libraries.processmodeling.MoveTo<Patch> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Delay<Patch> instantiate_patchDelay_xjal() {
    com.anylogic.libraries.processmodeling.Delay<Patch> _result_xjal = new com.anylogic.libraries.processmodeling.Delay<Patch>( getEngine(), this, null ) {
      @Override
      public double delayTime( Patch agent ) {
        return _patchDelay_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_patchDelay_xjal( final com.anylogic.libraries.processmodeling.Delay<Patch> self, TableInput _t ) {
    self.type = self._type_DefaultValue_xjal();
    self.capacity = 
100 
;
    self.maximumCapacity = self._maximumCapacity_DefaultValue_xjal();
    self.entityLocation = self._entityLocation_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
    self.restoreEntityLocationOnExit = self._restoreEntityLocationOnExit_DefaultValue_xjal();
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_patchDelay_xjal( com.anylogic.libraries.processmodeling.Delay<Patch> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Sink<Patch> instantiate_patchSink_xjal() {
    com.anylogic.libraries.processmodeling.Sink<Patch> _result_xjal = new com.anylogic.libraries.processmodeling.Sink<Patch>( getEngine(), this, null ) {
      @Override
      public void onEnter( Patch agent ) {
        _patchSink_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_patchSink_xjal( final com.anylogic.libraries.processmodeling.Sink<Patch> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_patchSink_xjal( com.anylogic.libraries.processmodeling.Sink<Patch> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Source<Patch> instantiate_sourcePatch_xjal() {
    com.anylogic.libraries.processmodeling.Source<Patch> _result_xjal = new com.anylogic.libraries.processmodeling.Source<Patch>( getEngine(), this, null ) {
      @Override
      public INode locationNode( Patch agent ) {
        return _sourcePatch_locationNode_xjal( this, agent );
      }
      @Override
      public Agent newEntity(  ) {
        return _sourcePatch_newEntity_xjal( this );
      }
      @Override
      public void onExit( Patch agent ) {
        _sourcePatch_onExit_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_sourcePatch_xjal( final com.anylogic.libraries.processmodeling.Source<Patch> self, TableInput _t ) {
    self.arrivalType = 
self.MANUAL 
;
    self.rate = self._rate_DefaultValue_xjal();
    self.firstArrivalMode = self._firstArrivalMode_DefaultValue_xjal();
    self.firstArrivalTime = self._firstArrivalTime_DefaultValue_xjal();
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.multipleEntitiesPerArrival = self._multipleEntitiesPerArrival_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.locationType = 
self.LOCATION_NODE 
;
    self.locationXYZInNetwork = self._locationXYZInNetwork_DefaultValue_xjal();
    self.enableCustomStartTime = self._enableCustomStartTime_DefaultValue_xjal();
    self.startTime = self._startTime_DefaultValue_xjal();
    self.addToCustomPopulation = self._addToCustomPopulation_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
    self.discardHangingEntities = self._discardHangingEntities_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_sourcePatch_xjal( com.anylogic.libraries.processmodeling.Source<Patch> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Patch instantiate_patches_xjal( final int index ) {
    Patch _result_xjal = new Patch( getEngine(), this, patches );
    
    patches._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_patches_xjal( final Patch self, final int index, TableInput _t ) {
    self.targetDevice = 
null 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_patches_xjal( Patch self, final int index, TableInput _t ) {
    self.setEnvironment( this );
double _x_xjal = 970.0
;
double _y_xjal = 460.0
;
double _z_xjal = 0.0
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected IoTDevice instantiate_devices_xjal( final int index ) {
    IoTDevice _result_xjal = new IoTDevice( getEngine(), this, devices );
    
    devices._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_devices_xjal( final IoTDevice self, final int index, TableInput _t ) {
    self.cvssScore = self._cvssScore_DefaultValue_xjal();
    self.deviceName = self._deviceName_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_devices_xjal( IoTDevice self, final int index, TableInput _t ) {
    self.setEnvironment( this );
	INode node_xjal = 
nodePlayground 
;
	self.setLocationRandomInside( node_xjal );

    // Port connections
  }

  private Agent _virusMove_destinationAgent_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Virus> self, Virus agent ) {
    Agent _value;
    _value = 
agent.targetDevice 
;
    return _value;
  }
  private boolean _virusMove_setSpeed_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Virus> self, Virus agent ) {
    boolean _value;
    _value = 
true 
;
    return _value;
  }
  private double _virusMove_speed_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Virus> self, Virus agent ) {
    double _value;
    _value = 
10000 
;
    return _value;
  }
  private double _virusDelay_delayTime_xjal( final com.anylogic.libraries.processmodeling.Delay<Virus> self, Virus agent ) {
    double _value;
    _value = 
"bruteforce".equals(attackMode)
		? passwordDictionary.size() / networkSpeed
		: 0 
;
    return _value;
  }
  private void _virusSink_onEnter_xjal( final com.anylogic.libraries.processmodeling.Sink<Virus> self, Virus agent ) {
    
if (agent.canInfect(agent.targetDevice)) {
	lastInfectingVirus = agent;
	traceln("[" + time() + "] Червь заразил "
			+ agent.targetDevice.deviceName + " (R0="
			+ agent.rzeroScore + ")");
	send("EXPOSE", agent.targetDevice);
} else {
	traceln("[" + time() + "] Червь НЕ смог заразить "
			+ agent.targetDevice.deviceName + " (R0="
			+ agent.rzeroScore + ")");
} 
;
  }
  private INode _sourceVirus_locationNode_xjal( final com.anylogic.libraries.processmodeling.Source<Virus> self, Virus agent ) {
    INode _value;
    _value = 
nodeVirus 
;
    return _value;
  }
  private Agent _sourceVirus_newEntity_xjal( final com.anylogic.libraries.processmodeling.Source<Virus> self ) {
    Agent _value;
    _value = 
new diploma.Virus() 
;
    return _value;
  }
  private void _sourceVirus_onExit_xjal( final com.anylogic.libraries.processmodeling.Source<Virus> self, Virus agent ) {
    
agent.targetDevice = pendingVirusTarget;
agent.rzeroScore = pendingVirusRZero;
agent.latencyPeriod = defaultLatencyPeriod; 
;
  }
  private Agent _patchMove_destinationAgent_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Patch> self, Patch agent ) {
    Agent _value;
    _value = 
agent.targetDevice 
;
    return _value;
  }
  private boolean _patchMove_setSpeed_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Patch> self, Patch agent ) {
    boolean _value;
    _value = 
true 
;
    return _value;
  }
  private double _patchMove_speed_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Patch> self, Patch agent ) {
    double _value;
    _value = 
10000 
;
    return _value;
  }
  private double _patchDelay_delayTime_xjal( final com.anylogic.libraries.processmodeling.Delay<Patch> self, Patch agent ) {
    double _value;
    _value = 
agent.targetDevice == null
		? 1.0 / networkSpeed
		: (uniform(agent.targetDevice.minPatchKB,
				agent.targetDevice.maxPatchKB)
				/ (networkSpeed * 125.0)
				+ uniform(agent.targetDevice.minInstallSec,
						agent.targetDevice.maxInstallSec)) 
;
    return _value;
  }
  private void _patchSink_onEnter_xjal( final com.anylogic.libraries.processmodeling.Sink<Patch> self, Patch agent ) {
    
send("PATCH", agent.targetDevice); 
;
  }
  private INode _sourcePatch_locationNode_xjal( final com.anylogic.libraries.processmodeling.Source<Patch> self, Patch agent ) {
    INode _value;
    _value = 
nodePatch 
;
    return _value;
  }
  private Agent _sourcePatch_newEntity_xjal( final com.anylogic.libraries.processmodeling.Source<Patch> self ) {
    Agent _value;
    _value = 
new diploma.Patch() 
;
    return _value;
  }
  private void _sourcePatch_onExit_xjal( final com.anylogic.libraries.processmodeling.Source<Patch> self, Patch agent ) {
    
agent.targetDevice = pendingPatchTarget; 
;
  }
  // Functions

  public void createVirus( double rzero, IoTDevice target ) { 

if (target.inState(IoTDevice.Infected)
		|| target.inState(IoTDevice.Exposed)
		|| target.inState(IoTDevice.Recovered))
	return;
traceln("[" + time() + "] Червь с R0=" + rzero
		+ " отправлен к " + target.deviceName);
virusTargets.add(target);
virusRZero.add(rzero); 
  }

  public void createPatch( IoTDevice target ) { 

traceln("[" + time() + "] Патч отправлен на "
		+ target.deviceName);
pendingPatchTarget = target;
sourcePatch.inject(1); 
  }

  
int 
 getInfectedCount(  ) { 

int count = 0;
for (IoTDevice d : devices) {
	if (d.inState(IoTDevice.Infected))
		count++;
}
return count; 
  }

  /**
   * GUI полного конструктора сети (добавление/удаление устройств, импорт/экспорт JSON).
   */
  void showConfigDialog(  ) { 

javax.swing.JFrame frame = new javax.swing.JFrame(
		"Конфигуратор IoT-сети");
frame.setSize(1100, 600);
frame.setLayout(new java.awt.BorderLayout());

javax.swing.JPanel topPanel = new javax.swing.JPanel();
topPanel.add(
		new javax.swing.JLabel("Скорость сети (Мбит/с):"));
javax.swing.JTextField networkSpeedField = new javax.swing.JTextField(
		Double.toString(networkSpeed), 5);
topPanel.add(networkSpeedField);
frame.add(topPanel, java.awt.BorderLayout.NORTH);

String[] columns = {"Имя", "X", "Y", "CVSS (0.0-10.0)",
		"Подсеть", "Шлюз к подсетям", "Логин", "Пароль",
		"minPatchKB", "maxPatchKB", "minInstallSec",
		"maxInstallSec"};
Object[][] data = {};

if (!configs.isEmpty()) {
	data = new Object[configs.size()][12];
	for (int i = 0; i < configs.size(); i++) {
		DeviceConfig dc = configs.get(i);
		data[i][0] = dc.name;
		data[i][1] = dc.x;
		data[i][2] = dc.y;
		data[i][3] = dc.cvss;
		data[i][4] = dc.segment;
		data[i][5] = dc.gatewaySegments;
		data[i][6] = dc.deviceLogin;
		data[i][7] = dc.devicePassword;
		data[i][8] = dc.minPatchKB;
		data[i][9] = dc.maxPatchKB;
		data[i][10] = dc.minInstallSec;
		data[i][11] = dc.maxInstallSec;
	}
}

javax.swing.JTable table = new javax.swing.JTable(
		new javax.swing.table.DefaultTableModel(data,
				columns));
javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(
		table);
frame.add(scrollPane, java.awt.BorderLayout.CENTER);

javax.swing.JPanel panel = new javax.swing.JPanel();
javax.swing.JButton addButton = new javax.swing.JButton(
		"Добавить");
javax.swing.JButton removeButton = new javax.swing.JButton(
		"Удалить");
javax.swing.JButton exportButton = new javax.swing.JButton(
		"Экспорт");
javax.swing.JButton importButton = new javax.swing.JButton(
		"Импорт");
javax.swing.JButton okButton = new javax.swing.JButton(
		"OК");

panel.add(addButton);
panel.add(removeButton);
panel.add(exportButton);
panel.add(importButton);
panel.add(okButton);
frame.add(panel, java.awt.BorderLayout.SOUTH);

addButton.addActionListener(e -> {
	javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table
			.getModel();
	model.addRow(new Object[]{"Device",
			100 + Math.random() * 400,
			100 + Math.random() * 300, 5.0, "Основная сеть",
			"", "admin", "admin", 100.0, 2000.0, 0.5, 3.0});
});

removeButton.addActionListener(e -> {
	javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table
			.getModel();
	if (table.getSelectedRow() != -1)
		model.removeRow(table.getSelectedRow());
});

exportButton.addActionListener(e -> {
	javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
	chooser.setSelectedFile(
			new java.io.File("iot_config.json"));
	if (chooser.showSaveDialog(
			frame) == javax.swing.JFileChooser.APPROVE_OPTION) {
		try {
			java.util.ArrayList<DeviceConfig> temp = new java.util.ArrayList<>();
			javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table
					.getModel();
			for (int i = 0; i < model.getRowCount(); i++) {
				temp.add(new DeviceConfig(
						(String) model.getValueAt(i, 0),
						Double.parseDouble(
								model.getValueAt(i, 1)
										.toString()),
						Double.parseDouble(
								model.getValueAt(i, 2)
										.toString()),
						Double.parseDouble(
								model.getValueAt(i, 3)
										.toString()),
						(String) model.getValueAt(i, 4),
						(String) model.getValueAt(i, 5),
						(String) model.getValueAt(i, 6),
						(String) model.getValueAt(i, 7),
						Double.parseDouble(
								model.getValueAt(i, 8)
										.toString()),
						Double.parseDouble(
								model.getValueAt(i, 9)
										.toString()),
						Double.parseDouble(
								model.getValueAt(i, 10)
										.toString()),
						Double.parseDouble(
								model.getValueAt(i, 11)
										.toString())));
			}
			java.io.PrintWriter pw = new java.io.PrintWriter(
					chooser.getSelectedFile(), "UTF-8");
			pw.println("[");
			for (int i = 0; i < temp.size(); i++) {
				DeviceConfig dc = temp.get(i);
				pw.print("  {\"name\":\"" + dc.name
						+ "\", \"x\":" + dc.x + ", \"y\":"
						+ dc.y + ", \"cvss\":" + dc.cvss
						+ ", \"segment\":\"" + dc.segment
						+ "\", \"gatewaySegments\":\""
						+ dc.gatewaySegments
						+ "\", \"deviceLogin\":\""
						+ dc.deviceLogin
						+ "\", \"devicePassword\":\""
						+ dc.devicePassword
						+ "\", \"minPatchKB\":"
						+ dc.minPatchKB
						+ ", \"maxPatchKB\":"
						+ dc.maxPatchKB
						+ ", \"minInstallSec\":"
						+ dc.minInstallSec
						+ ", \"maxInstallSec\":"
						+ dc.maxInstallSec + "}");
				if (i < temp.size() - 1)
					pw.println(",");
				else
					pw.println();
			}
			pw.println("]");
			pw.close();
			traceln("Экспортировано: " + temp.size()
					+ " устройств");
		} catch (Exception ex) {
			traceln("Ошибка экспорта: " + ex.getMessage());
		}
	}
});

importButton.addActionListener(e -> {
	javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
	if (chooser.showOpenDialog(
			frame) == javax.swing.JFileChooser.APPROVE_OPTION) {
		try {
			String content = new String(
					java.nio.file.Files.readAllBytes(chooser
							.getSelectedFile().toPath()),
					"UTF-8");
			javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table
					.getModel();
			model.setRowCount(0);
			content = content.trim();
			content = content.substring(1,
					content.length() - 1);
			int depth = 0;
			StringBuilder current = new StringBuilder();
			for (char c : content.toCharArray()) {
				if (c == '{')
					depth++;
				if (depth > 0)
					current.append(c);
				if (c == '}') {
					depth--;
					if (depth == 0) {
						String obj = current.toString();
						String name = "", segment = "",
								gw = "", login = "",
								pass = "";
						double x = 0, y = 0, cvss = 5;
						double minPatchKB = 100,
								maxPatchKB = 2000,
								minInstallSec = 0.5,
								maxInstallSec = 3.0;
						for (String part : obj
								.replace("{", "")
								.replace("}", "")
								.split(",")) {
							String[] kv = part.split(":",
									2);
							String key = kv[0].trim()
									.replace("\"", "");
							String val = kv.length > 1
									? kv[1].trim().replace(
											"\"", "")
									: "";
							switch (key) {
								case "name" :
									name = val;
									break;
								case "x" :
									x = Double.parseDouble(
											val);
									break;
								case "y" :
									y = Double.parseDouble(
											val);
									break;
								case "cvss" :
									cvss = Double
											.parseDouble(
													val);
									break;
								case "segment" :
									segment = val;
									break;
								case "gatewaySegments" :
									gw = val;
									break;
								case "deviceLogin" :
									login = val;
									break;
								case "devicePassword" :
									pass = val;
									break;
								case "minPatchKB" :
									minPatchKB = Double
											.parseDouble(
													val);
									break;
								case "maxPatchKB" :
									maxPatchKB = Double
											.parseDouble(
													val);
									break;
								case "minInstallSec" :
									minInstallSec = Double
											.parseDouble(
													val);
									break;
								case "maxInstallSec" :
									maxInstallSec = Double
											.parseDouble(
													val);
									break;
							}
						}
						if (name != null
								&& !name.trim().isEmpty()) {
							model.addRow(new Object[]{name,
									x, y, cvss, segment, gw,
									login, pass, minPatchKB,
									maxPatchKB,
									minInstallSec,
									maxInstallSec});
						}
						current = new StringBuilder();
					}
				}
			}
			traceln("Импортировано: " + model.getRowCount()
					+ " устройств");
		} catch (Exception ex) {
			traceln("Ошибка импорта: " + ex.getMessage());
		}
	}
});

okButton.addActionListener(e -> {
	configs.clear();
	javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table
			.getModel();
	for (int i = 0; i < model.getRowCount(); i++) {
		configs.add(new DeviceConfig(
				(String) model.getValueAt(i, 0),
				Double.parseDouble(
						model.getValueAt(i, 1).toString()),
				Double.parseDouble(
						model.getValueAt(i, 2).toString()),
				Double.parseDouble(
						model.getValueAt(i, 3).toString()),
				(String) model.getValueAt(i, 4),
				(String) model.getValueAt(i, 5),
				(String) model.getValueAt(i, 6),
				(String) model.getValueAt(i, 7),
				Double.parseDouble(
						model.getValueAt(i, 8).toString()),
				Double.parseDouble(
						model.getValueAt(i, 9).toString()),
				Double.parseDouble(
						model.getValueAt(i, 10).toString()),
				Double.parseDouble(model.getValueAt(i, 11)
						.toString())));
	}
	try {
		networkSpeed = Double
				.parseDouble(networkSpeedField.getText());
	} catch (NumberFormatException ex) {
		networkSpeed = 1.0;
	}
	frame.dispose();
});

frame.setLocationRelativeTo(null);
frame.setVisible(true); 
  }

  /**
   * GUI главного меню.
   */
  void showMainMenu(  ) { 

javax.swing.JFrame menuFrame = new javax.swing.JFrame(
		"Настройка симуляции");
menuFrame.setSize(550, 300);
menuFrame.setLayout(new java.awt.BorderLayout());

javax.swing.JLabel titleLabel = new javax.swing.JLabel(
		"Панель управления моделью",
		javax.swing.JLabel.CENTER);
titleLabel.setFont(
		new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
menuFrame.add(titleLabel, java.awt.BorderLayout.NORTH);

javax.swing.JPanel mainPanel = new javax.swing.JPanel(
		new java.awt.GridLayout(1, 2, 10, 0));

javax.swing.JPanel leftPanel = new javax.swing.JPanel();
leftPanel.setLayout(new javax.swing.BoxLayout(leftPanel,
		javax.swing.BoxLayout.Y_AXIS));
leftPanel.setBorder(javax.swing.BorderFactory
		.createTitledBorder("Управление"));

javax.swing.JButton configButton = new javax.swing.JButton(
		"Конфигуратор IoT-сети");
javax.swing.JButton wormButton = new javax.swing.JButton(
		"Параметры вредоносного ПО");
javax.swing.JButton defenseButton = new javax.swing.JButton(
		"Параметры защиты");
javax.swing.JButton saveAllButton = new javax.swing.JButton(
		"Сохранить все настройки");
javax.swing.JButton loadAllButton = new javax.swing.JButton(
		"Загрузить все настройки");
javax.swing.JButton startButton = new javax.swing.JButton(
		"Запустить симуляцию");

configButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);
wormButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);
defenseButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);
saveAllButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);
loadAllButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);
startButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);

leftPanel.add(configButton);
leftPanel.add(javax.swing.Box.createVerticalStrut(8));
leftPanel.add(wormButton);
leftPanel.add(javax.swing.Box.createVerticalStrut(8));
leftPanel.add(defenseButton);
leftPanel.add(javax.swing.Box.createVerticalStrut(8));
leftPanel.add(saveAllButton);
leftPanel.add(javax.swing.Box.createVerticalStrut(5));
leftPanel.add(loadAllButton);
leftPanel.add(javax.swing.Box.createVerticalStrut(12));
leftPanel.add(startButton);

javax.swing.JPanel rightPanel = new javax.swing.JPanel();
rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel,
		javax.swing.BoxLayout.Y_AXIS));
rightPanel.setBorder(javax.swing.BorderFactory
		.createTitledBorder("Калькуляторы CVSS"));

javax.swing.JLabel calcDesc = new javax.swing.JLabel(
		"<html><center>Открыть в браузере:</center></html>");
calcDesc.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);

javax.swing.JButton calcFirstButton = new javax.swing.JButton(
		"FIRST CVSS 4.0");
javax.swing.JButton calcBduButton = new javax.swing.JButton(
		"БДУ ФСТЭК");

calcFirstButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);
calcBduButton.setAlignmentX(
		javax.swing.JComponent.CENTER_ALIGNMENT);

rightPanel.add(calcDesc);
rightPanel.add(javax.swing.Box.createVerticalStrut(10));
rightPanel.add(calcFirstButton);
rightPanel.add(javax.swing.Box.createVerticalStrut(5));
rightPanel.add(calcBduButton);

mainPanel.add(leftPanel);
mainPanel.add(rightPanel);
menuFrame.add(mainPanel, java.awt.BorderLayout.CENTER);

configButton.addActionListener(e -> showConfigDialog());
wormButton.addActionListener(e -> showWormConfigDialog());
defenseButton
		.addActionListener(e -> showDefenseConfigDialog());

startButton.addActionListener(e -> {
	if (!configs.isEmpty()) {
		while (devices.size() > 0) {
			devices.get(0).setDestroyed();
		}
		for (DeviceConfig config : configs) {
			IoTDevice device = add_devices();
			device.setXY(config.x, config.y);
			device.cvssScore = config.cvss;
			device.deviceName = config.name;
			device.segment = config.segment;
			device.deviceLogin = config.deviceLogin;
			device.devicePassword = config.devicePassword;
			device.gatewaySegments = config.gatewaySegments;
			device.minPatchKB = config.minPatchKB;
			device.maxPatchKB = config.maxPatchKB;
			device.minInstallSec = config.minInstallSec;
			device.maxInstallSec = config.maxInstallSec;
			device.coorX = config.x;
			device.coorY = config.y;
		}
	}
	menuFrame.dispose();
});

calcFirstButton.addActionListener(e -> {
	try {
		java.awt.Desktop.getDesktop()
				.browse(new java.net.URI(
						"https://www.first.org/cvss/calculator/v4-0"));
	} catch (Exception ex) {
		traceln("Не удалось открыть браузер: "
				+ ex.getMessage());
	}
});

calcBduButton.addActionListener(e -> {
	try {
		java.awt.Desktop.getDesktop()
				.browse(new java.net.URI(
						"https://bdu.fstec.ru/calc4"));
	} catch (Exception ex) {
		traceln("Не удалось открыть браузер: "
				+ ex.getMessage());
	}
});

saveAllButton.addActionListener(e -> {
	javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
	chooser.setSelectedFile(
			new java.io.File("simulation_config.json"));
	if (chooser.showSaveDialog(
			menuFrame) == javax.swing.JFileChooser.APPROVE_OPTION) {
		try {
			java.io.PrintWriter pw = new java.io.PrintWriter(
					chooser.getSelectedFile(), "UTF-8");
			pw.println("{");
			pw.println("  \"devices\": [");
			if (!configs.isEmpty()) {
				for (int i = 0; i < configs.size(); i++) {
					DeviceConfig dc = configs.get(i);
					pw.print("    {\"name\":\"" + dc.name
							+ "\", \"x\":" + dc.x
							+ ", \"y\":" + dc.y
							+ ", \"cvss\":" + dc.cvss
							+ ", \"segment\":\""
							+ dc.segment
							+ "\", \"gatewaySegments\":\""
							+ dc.gatewaySegments
							+ "\", \"deviceLogin\":\""
							+ dc.deviceLogin
							+ "\", \"devicePassword\":\""
							+ dc.devicePassword
							+ "\", \"minPatchKB\":"
							+ dc.minPatchKB
							+ ", \"maxPatchKB\":"
							+ dc.maxPatchKB
							+ ", \"minInstallSec\":"
							+ dc.minInstallSec
							+ ", \"maxInstallSec\":"
							+ dc.maxInstallSec + "}");
					if (i < configs.size() - 1)
						pw.println(",");
					else
						pw.println();
				}
			}
			pw.println("  ],");
			pw.println("  \"wormParams\": {");
			pw.println("    \"rzero\":" + rzero + ",");
			pw.println("    \"attackMode\":\"" + attackMode
					+ "\",");
			pw.println("    \"patientZeroName\":\""
					+ patientZeroName + "\"");
			pw.println("  },");
			pw.println("  \"defenseParams\": {");
			pw.println("    \"timeToDetect\":"
					+ timeToDetect + ",");
			pw.println("    \"timeToRespond\":"
					+ timeToRespond + ",");
			pw.println("    \"timeToDevelopPatch\":"
					+ timeToDevelopPatch + ",");
			pw.println("    \"timeToDeploy\":"
					+ timeToDeploy + ",");
			pw.println("    \"autoIsolation\":"
					+ autoIsolation + ",");
			pw.println("    \"passwordChangeMode\":\""
					+ passwordChangeMode + "\",");
			pw.println("    \"defaultLatencyPeriod\":"
					+ defaultLatencyPeriod);
			pw.println("  },");
			pw.println("  \"passwordDictionary\": [");
			if (passwordDictionary != null
					&& !passwordDictionary.isEmpty()) {
				for (int i = 0; i < passwordDictionary
						.size(); i++) {
					pw.print("    \""
							+ passwordDictionary.get(i)
							+ "\"");
					if (i < passwordDictionary.size() - 1)
						pw.println(",");
					else
						pw.println();
				}
			}
			pw.println("  ]");
			pw.println("}");
			pw.close();
			traceln("Все настройки сохранены в "
					+ chooser.getSelectedFile().getName());
		} catch (Exception ex) {
			traceln("Ошибка сохранения настроек: "
					+ ex.getMessage());
		}
	}
});

loadAllButton.addActionListener(e -> {
	javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
	if (chooser.showOpenDialog(
			menuFrame) == javax.swing.JFileChooser.APPROVE_OPTION) {
		try {
			String content = new String(
					java.nio.file.Files.readAllBytes(chooser
							.getSelectedFile().toPath()),
					"UTF-8");
			content = content.trim();
			int devStart = content.indexOf("\"devices\"");
			if (devStart != -1) {
				int arrStart = content.indexOf("[",
						devStart);
				int arrEnd = content.lastIndexOf("]");
				if (arrStart != -1 && arrEnd != -1
						&& arrEnd > arrStart) {
					String devicesBlock = content
							.substring(arrStart + 1, arrEnd)
							.trim();
					configs.clear();
					if (!devicesBlock.isEmpty()) {
						int depth = 0;
						StringBuilder current = new StringBuilder();
						for (char c : devicesBlock
								.toCharArray()) {
							if (c == '{')
								depth++;
							if (depth > 0)
								current.append(c);
							if (c == '}') {
								depth--;
								if (depth == 0) {
									String obj = current
											.toString();
									String name = "",
											segment = "",
											gw = "",
											login = "",
											pass = "";
									double x = 0, y = 0,
											cvss = 5;
									double minPatchKB = 100,
											maxPatchKB = 2000,
											minInstallSec = 0.5,
											maxInstallSec = 3.0;
									ArrayList<String> parts = new ArrayList<>();
									StringBuilder sb = new StringBuilder();
									boolean inQuotes = false;
									for (char ch : obj
											.replace("{",
													"")
											.replace("}",
													"")
											.toCharArray()) {
										if (ch == '"') {
											inQuotes = !inQuotes;
											sb.append(ch);
										} else if (ch == ','
												&& !inQuotes) {
											parts.add(sb
													.toString()
													.trim());
											sb.setLength(0);
										} else {
											sb.append(ch);
										}
									}
									if (sb.length() > 0)
										parts.add(sb
												.toString()
												.trim());

									for (String part : parts) {
										String[] kv = part
												.split(":",
														2);
										String key = kv[0]
												.trim()
												.replace(
														"\"",
														"");
										String val = kv.length > 1
												? kv[1].trim()
														.replace(
																"\"",
																"")
												: "";
										switch (key) {
											case "name" :
												name = val;
												break;
											case "x" :
												x = Double
														.parseDouble(
																val);
												break;
											case "y" :
												y = Double
														.parseDouble(
																val);
												break;
											case "cvss" :
												cvss = Double
														.parseDouble(
																val);
												break;
											case "segment" :
												segment = val;
												break;
											case "gatewaySegments" :
												gw = val;
												break;
											case "deviceLogin" :
												login = val;
												break;
											case "devicePassword" :
												pass = val;
												break;
											case "minPatchKB" :
												minPatchKB = Double
														.parseDouble(
																val);
												break;
											case "maxPatchKB" :
												maxPatchKB = Double
														.parseDouble(
																val);
												break;
											case "minInstallSec" :
												minInstallSec = Double
														.parseDouble(
																val);
												break;
											case "maxInstallSec" :
												maxInstallSec = Double
														.parseDouble(
																val);
												break;
										}
									}
									if (name != null
											&& !name.trim()
													.isEmpty()) {
										configs.add(
												new DeviceConfig(
														name,
														x,
														y,
														cvss,
														segment,
														gw,
														login,
														pass,
														minPatchKB,
														maxPatchKB,
														minInstallSec,
														maxInstallSec));
									}
									current = new StringBuilder();
								}
							}
						}
					}
				}
			}
			int wormStart = content
					.indexOf("\"wormParams\"");
			if (wormStart != -1) {
				int objStart = content.indexOf("{",
						wormStart);
				int objEnd = content.indexOf("}", objStart);
				if (objStart != -1 && objEnd != -1) {
					String wormBlock = content.substring(
							objStart + 1, objEnd);
					for (String part : wormBlock
							.split(",")) {
						String[] kv = part.split(":", 2);
						String key = kv[0].trim()
								.replace("\"", "");
						String val = kv.length > 1
								? kv[1].trim().replace("\"",
										"")
								: "";
						switch (key) {
							case "rzero" :
								rzero = Double
										.parseDouble(val);
								break;
							case "attackMode" :
								attackMode = val;
								break;
							case "patientZeroName" :
								patientZeroName = val;
								break;
						}
					}
				}
			}
			int defStart = content
					.indexOf("\"defenseParams\"");
			if (defStart != -1) {
				int objStart = content.indexOf("{",
						defStart);
				int objEnd = content.indexOf("}", objStart);
				if (objStart != -1 && objEnd != -1) {
					String defBlock = content.substring(
							objStart + 1, objEnd);
					for (String part : defBlock
							.split(",")) {
						String[] kv = part.split(":", 2);
						String key = kv[0].trim()
								.replace("\"", "");
						String val = kv.length > 1
								? kv[1].trim().replace("\"",
										"")
								: "";
						switch (key) {
							case "timeToDetect" :
								timeToDetect = Double
										.parseDouble(val);
								break;
							case "timeToRespond" :
								timeToRespond = Double
										.parseDouble(val);
								break;
							case "timeToDevelopPatch" :
								timeToDevelopPatch = Double
										.parseDouble(val);
								break;
							case "timeToDeploy" :
								timeToDeploy = Double
										.parseDouble(val);
								break;
							case "autoIsolation" :
								autoIsolation = Boolean
										.parseBoolean(val);
								break;
							case "passwordChangeMode" :
								passwordChangeMode = val;
								break;
							case "defaultLatencyPeriod" :
								defaultLatencyPeriod = Double
										.parseDouble(val);
								break;
						}
					}
				}
			}
			int dictStart = content
					.indexOf("\"passwordDictionary\"");
			if (dictStart != -1) {
				int arrStart = content.indexOf("[",
						dictStart);
				int arrEnd = content.indexOf("]", arrStart);
				if (arrStart != -1 && arrEnd != -1) {
					String dictBlock = content.substring(
							arrStart + 1, arrEnd);
					passwordDictionary.clear();
					if (!dictBlock.trim().isEmpty()) {
						for (String entry : dictBlock
								.split(",")) {
							String clean = entry.trim()
									.replace("\"", "");
							if (!clean.isEmpty()) {
								passwordDictionary
										.add(clean);
							}
						}
					}
				}
			}
			traceln("Все настройки загружены из "
					+ chooser.getSelectedFile().getName());
		} catch (Exception ex) {
			traceln("Ошибка загрузки настроек: "
					+ ex.getMessage());
		}
	}
});

menuFrame.setLocationRelativeTo(null);
menuFrame.setVisible(true);

while (menuFrame.isVisible()) {
	try {
		Thread.sleep(100);
	} catch (InterruptedException ex) {
	}
} 
  }

  /**
   * GUI настройки поведения червя.
   */
  void showWormConfigDialog(  ) { 

javax.swing.JFrame wormFrame = new javax.swing.JFrame(
		"Параметры вредоносного ПО");
wormFrame.setSize(600, 450);
wormFrame.setLayout(new javax.swing.BoxLayout(
		wormFrame.getContentPane(),
		javax.swing.BoxLayout.Y_AXIS));

javax.swing.JLabel r0Label = new javax.swing.JLabel(
		"Коэффициент репродукции (R0):");
r0Label.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

javax.swing.JTextField r0Field = new javax.swing.JTextField(
		String.format("%.1f", rzero));
r0Field.setMaximumSize(new java.awt.Dimension(100, 30));

javax.swing.JLabel r0Hint = new javax.swing.JLabel(
		"<html><font size='2'>"
				+ "R0 - среднее число устройств, заражаемых одним инфицированным.<br>"
				+ "<b>Пример:</b> R0 = 2 означает, что каждое заражённое устройство успевает заразить ещё два.<br>"
				+ "R0 > 1 - лавинообразное распространение, а при R0 < 1 - эпидемия затухает<br>"
				+ "</font></html>");
r0Hint.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

javax.swing.JLabel latencyLabel = new javax.swing.JLabel(
		"Латентный период (мин):");
latencyLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
javax.swing.JTextField latencyField = new javax.swing.JTextField(
		Double.toString(defaultLatencyPeriod));
latencyField
		.setMaximumSize(new java.awt.Dimension(100, 30));
javax.swing.JLabel latencyHint = new javax.swing.JLabel(
		"<html><font size='2'>Время между заражением и активацией червя на устройстве (0 - мгновенно).</font></html>");
latencyHint
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

javax.swing.JLabel scanIntervalLabel = new javax.swing.JLabel(
		"Интервал сканирования (мин):");
scanIntervalLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
javax.swing.JTextField scanIntervalField = new javax.swing.JTextField(
		Double.toString(scanInterval));
scanIntervalField
		.setMaximumSize(new java.awt.Dimension(100, 30));
javax.swing.JLabel scanIntervalHint = new javax.swing.JLabel(
		"<html><font size='2'>Как часто заражённое устройство повторяет попытку атаки на соседей.</font></html>");
scanIntervalHint
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

javax.swing.JLabel modeLabel = new javax.swing.JLabel(
		"Режим атаки:");
modeLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
String[] modes = {"Перебор паролей",
		"Эксплуатация уязвимостей", "Комбинированный"};
javax.swing.JComboBox<String> modeCombo = new javax.swing.JComboBox<>(
		modes);
modeCombo.setMaximumSize(new java.awt.Dimension(200, 30));
if ("bruteforce".equals(attackMode))
	modeCombo.setSelectedIndex(0);
else if ("exploit".equals(attackMode))
	modeCombo.setSelectedIndex(1);
else
	modeCombo.setSelectedIndex(2);

javax.swing.JLabel initialLabel = new javax.swing.JLabel(
		"Имя начального устройства:");
initialLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
javax.swing.JTextField initialField = new javax.swing.JTextField(
		patientZeroName);
initialField
		.setMaximumSize(new java.awt.Dimension(200, 30));

javax.swing.JButton saveButton = new javax.swing.JButton(
		"Сохранить");
saveButton
		.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

wormFrame.add(r0Label);
wormFrame.add(r0Field);
wormFrame.add(r0Hint);
wormFrame.add(javax.swing.Box.createVerticalStrut(10));
wormFrame.add(latencyLabel);
wormFrame.add(latencyField);
wormFrame.add(latencyHint);
wormFrame.add(javax.swing.Box.createVerticalStrut(10));
wormFrame.add(modeLabel);
wormFrame.add(modeCombo);
wormFrame.add(javax.swing.Box.createVerticalStrut(10));
wormFrame.add(initialLabel);
wormFrame.add(initialField);
wormFrame.add(javax.swing.Box.createVerticalStrut(15));
wormFrame.add(scanIntervalLabel);
wormFrame.add(scanIntervalField);
wormFrame.add(scanIntervalHint);
wormFrame.add(javax.swing.Box.createVerticalStrut(10));
wormFrame.add(saveButton);

saveButton.addActionListener(e -> {
	try {
		double newR0 = Double
				.parseDouble(r0Field.getText());
		if (newR0 < 0) {
			newR0 = 0;
		}
		rzero = newR0;
	} catch (NumberFormatException ex) {
		traceln("Некорректное значение R0, оставлено предыдущее: "
				+ rzero);
	}
	int modeIdx = modeCombo.getSelectedIndex();
	if (modeIdx == 0)
		attackMode = "bruteforce";
	else if (modeIdx == 1)
		attackMode = "exploit";
	else
		attackMode = "combined";
	patientZeroName = initialField.getText().trim();
	try {
		defaultLatencyPeriod = Double
				.parseDouble(latencyField.getText());
	} catch (NumberFormatException ex) {
		defaultLatencyPeriod = 1.0;
	}
	try {
		scanInterval = Double
				.parseDouble(scanIntervalField.getText());
	} catch (NumberFormatException ex) {
		scanInterval = 5.0;
	}
	wormFrame.dispose();
});

wormFrame.setLocationRelativeTo(null);
wormFrame.setVisible(true); 
  }

  /**
   * GUI настройки защитных мероприятий.
   */
  void showDefenseConfigDialog(  ) { 

javax.swing.JFrame defenseFrame = new javax.swing.JFrame(
		"Параметры защиты");
defenseFrame.setSize(300, 380);
defenseFrame.setLayout(new javax.swing.BoxLayout(
		defenseFrame.getContentPane(),
		javax.swing.BoxLayout.Y_AXIS));

javax.swing.JLabel detectLabel = new javax.swing.JLabel(
		"Время до обнаружения (мин):");
detectLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
javax.swing.JTextField detectField = new javax.swing.JTextField(
		Double.toString(timeToDetect));
detectField.setMaximumSize(new java.awt.Dimension(200, 30));

javax.swing.JLabel respondLabel = new javax.swing.JLabel(
		"Время реакции (мин):");
respondLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
javax.swing.JTextField respondField = new javax.swing.JTextField(
		Double.toString(timeToRespond));
respondField
		.setMaximumSize(new java.awt.Dimension(200, 30));

javax.swing.JLabel developLabel = new javax.swing.JLabel(
		"Время разработки патча (мин):");
developLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
javax.swing.JTextField developField = new javax.swing.JTextField(
		Double.toString(timeToDevelopPatch));
developField
		.setMaximumSize(new java.awt.Dimension(200, 30));

javax.swing.JLabel deployLabel = new javax.swing.JLabel(
		"Задержка доставки патча (сек):");
deployLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
javax.swing.JTextField deployField = new javax.swing.JTextField(
		Double.toString(timeToDeploy));
deployField.setMaximumSize(new java.awt.Dimension(200, 30));

javax.swing.JCheckBox autoIsolationCheck = new javax.swing.JCheckBox(
		"Автоматическая изоляция подсетей");
autoIsolationCheck.setSelected(autoIsolation);
autoIsolationCheck
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

javax.swing.JLabel pwdModeLabel = new javax.swing.JLabel(
		"Смена пароля после лечения:");
pwdModeLabel
		.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
String[] pwdModes = {"После перебора паролей", "Всегда"};
javax.swing.JComboBox<String> pwdModeCombo = new javax.swing.JComboBox<>(
		pwdModes);
pwdModeCombo
		.setMaximumSize(new java.awt.Dimension(200, 30));
if ("bruteforce".equals(passwordChangeMode))
	pwdModeCombo.setSelectedIndex(0);
else
	pwdModeCombo.setSelectedIndex(1);

javax.swing.JButton saveButton = new javax.swing.JButton(
		"Сохранить");
saveButton
		.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

defenseFrame.add(detectLabel);
defenseFrame.add(detectField);
defenseFrame.add(javax.swing.Box.createVerticalStrut(10));
defenseFrame.add(respondLabel);
defenseFrame.add(respondField);
defenseFrame.add(javax.swing.Box.createVerticalStrut(10));
defenseFrame.add(developLabel);
defenseFrame.add(developField);
defenseFrame.add(javax.swing.Box.createVerticalStrut(10));
defenseFrame.add(deployLabel);
defenseFrame.add(deployField);
defenseFrame.add(javax.swing.Box.createVerticalStrut(15));
defenseFrame.add(autoIsolationCheck);
defenseFrame.add(javax.swing.Box.createVerticalStrut(10));
defenseFrame.add(pwdModeLabel);
defenseFrame.add(pwdModeCombo);
defenseFrame.add(javax.swing.Box.createVerticalStrut(10));
defenseFrame.add(saveButton);

saveButton.addActionListener(e -> {
	try {
		timeToDetect = Double
				.parseDouble(detectField.getText());
		timeToRespond = Double
				.parseDouble(respondField.getText());
		timeToDevelopPatch = Double
				.parseDouble(developField.getText());
		timeToDeploy = Double
				.parseDouble(deployField.getText());
	} catch (NumberFormatException ex) {
		timeToDetect = 5;
		timeToRespond = 2;
		timeToDevelopPatch = 10;
		timeToDeploy = 1;
	}
	autoIsolation = autoIsolationCheck.isSelected();
	int pwdIdx = pwdModeCombo.getSelectedIndex();
	if (pwdIdx == 0)
		passwordChangeMode = "bruteforce";
	else
		passwordChangeMode = "always";
	defenseFrame.dispose();
});

defenseFrame.setLocationRelativeTo(null);
defenseFrame.setVisible(true); 
  }

  /**
   * Возвращает список устройств, доступных для атаки с данного заражённого устройства (учёт подсетей и шлюзов).
   */
  
ArrayList<IoTDevice> 
 getVisibleDevices( IoTDevice infectedDevice ) { 

ArrayList<IoTDevice> targets = new ArrayList<>();
String mySegment = infectedDevice.segment != null
		? infectedDevice.segment
		: "";
String gateway = infectedDevice.gatewaySegments != null
		? infectedDevice.gatewaySegments
		: "";

ArrayList<String> visibleSegments = new ArrayList<>();
visibleSegments.add(mySegment);
if (!gateway.isEmpty()) {
	String[] gwSegments = gateway.split(",");
	for (String gs : gwSegments) {
		String trimmed = gs.trim();
		if (!trimmed.isEmpty()
				&& !visibleSegments.contains(trimmed)) {
			visibleSegments.add(trimmed);
		}
	}
}

for (IoTDevice d : devices) {
	if (d.getIndex() == infectedDevice.getIndex())
		continue;

	if (!d.inState(IoTDevice.Susceptible))
		continue;
	if (isolatedSegments != null
			&& isolatedSegments.contains(d.segment))
		continue;
	if (!visibleSegments.contains(d.segment))
		continue;

	targets.add(d);
}
return targets; 
  }

  
int 
 getRecoveredCount(  ) { 

int count = 0;
for (IoTDevice d : devices) {
	if (d.inState(IoTDevice.Recovered))
		count++;
}
return count; 
  }

  
int 
 getExposedCount(  ) { 

int count = 0;
for (IoTDevice d : devices) {
	if (d.inState(IoTDevice.Exposed))
		count++;
}
return count; 
  }

  
int 
 getSusceptibleCount(  ) { 

int count = 0;
for (IoTDevice d : devices) {
	if (d.inState(IoTDevice.Susceptible))
		count++;
}
return count; 
  }

  void updateAllDS(  ) { 

susceptibleDS.update();
exposedDS.update();
infectedDS.update();
recoveredDS.update(); 
  }

  void writeDataSetToSheet( org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String sheetName, DataSet ds ) { 

org.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook
		.createSheet(sheetName);

org.apache.poi.xssf.usermodel.XSSFRow headerRow = sheet
		.createRow(0);
headerRow.createCell(0).setCellValue("Time");
headerRow.createCell(1).setCellValue("Value");

int rowIdx = 1;
int count = ds.size();
for (int i = 0; i < count; i++) {
	org.apache.poi.xssf.usermodel.XSSFRow row = sheet
			.createRow(rowIdx++);
	row.createCell(0).setCellValue(ds.getX(i));
	row.createCell(1).setCellValue(ds.getY(i));
} 
  }

  /**
   * Запускает таймер обнаружения при первом заражении.
   */
  void triggerDetectionIfNeeded(  ) { 

if (firstInfectionTime == -1) {
	firstInfectionTime = time();
	detectionEvent.restart(timeToDetect, MINUTE);
	traceln("[" + time()
			+ "] Обнаружение запланировано через "
			+ timeToDetect + " мин.");
} 
  }
  // Analysis Data Elements
private double _datasetUpdateTime_xjal() {
	return time();
}
  public DataSet infectedDS = new DataSet( 1000, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), _infectedDS_YValue() );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _infectedDS_YValue() {
    return 
getInfectedCount() 
;
  }
  
  public DataSet susceptibleDS = new DataSet( 1000, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), _susceptibleDS_YValue() );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _susceptibleDS_YValue() {
    return 
getSusceptibleCount() 
;
  }
  
  public DataSet exposedDS = new DataSet( 1000, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), _exposedDS_YValue() );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _exposedDS_YValue() {
    return 
getExposedCount() 
;
  }
  
  public DataSet recoveredDS = new DataSet( 1000, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( BasicDataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), _recoveredDS_YValue() );
      _lastUpdateX = time();
    }
    @Override
    public double getDataXValue() {
      return time();
    }
  } );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _recoveredDS_YValue() {
    return 
getRecoveredCount() 
;
  }
  
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1000.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _excelButton_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text21_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _text21 = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _viruses_presentation = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _patches_presentation = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _devices_presentation = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _plotStates = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _excelButton = 13;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 14;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(nodeVirus, nodePatch, text21, nodePlayground, excelButton, plotStates, wall1, wall, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, text, text1, text2, text3, text4, text5, text6);
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _nodePlayground_pointsDX_xjal() {
    return new double[] {  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _nodePlayground_pointsDY_xjal() {
    return new double[] {  };
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _excelButton: {
          ShapeButton self = this.excelButton;
try {
	org.apache.poi.xssf.usermodel.XSSFWorkbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();

	writeDataSetToSheet(workbook, "Susceptible",
			susceptibleDS);
	writeDataSetToSheet(workbook, "Exposed", exposedDS);
	writeDataSetToSheet(workbook, "Infected", infectedDS);
	writeDataSetToSheet(workbook, "Recovered", recoveredDS);

	String fileName = "results_"
			+ System.currentTimeMillis() + ".xlsx";
	java.io.FileOutputStream out = new java.io.FileOutputStream(
			fileName);
	workbook.write(out);
	out.close();
	workbook.close();

	traceln("Результаты экспортированы в " + fileName);
} catch (Exception ex) {
	traceln("Ошибка экспорта в Excel: " + ex.getMessage());
} 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  protected ShapeButton excelButton;
  protected TimePlot plotStates;
  protected ShapeText text21;
  protected ShapeText text;
  protected ShapeText text1;
  protected ShapeText text2;
  protected ShapeText text3;
  protected ShapeText text4;
  protected ShapeText text5;
  protected ShapeText text6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _viruses_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( Main.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup viruses_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _patches_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( Main.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup patches_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _devices_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( Main.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );
    return shape;
  }

  protected ShapeAgentPopulationGroup devices_presentation;
  protected PointNode nodeVirus;
  protected PointNode nodePatch;
  protected RectangularNode<Agent> nodePlayground;
  protected RectangularWall wall1;
  protected RectangularWall wall;
  protected RectangularWall wall2;
  protected RectangularWall wall3;
  protected RectangularWall wall4;
  protected RectangularWall wall5;
  protected RectangularWall wall6;
  protected RectangularWall wall7;
  protected RectangularWall wall8;
  protected RectangularWall wall9;
  protected RectangularWall wall10;
  protected RectangularWall wall11;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    excelButton = new ShapeButton(
Main.this, true, 0.0, 560.0,
			140.0, 30.0,
            black, true,
_excelButton_Font,
			"Экспорт в Excel" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _excelButton, 0 );
      }
    };
    text21 = new ShapeText(
        SHAPE_DRAW_2D, true,230.0, 610.0, 0.0, 0.0,
        black,"График состояний устройств",
        _text21_Font, ALIGNMENT_LEFT );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,250.0, -60.0, 0.0, 0.0,
        black,"Параметры модели",
        _text_Font, ALIGNMENT_CENTER );
    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,460.0, -300.0, 0.0, 0.0,
        black,"Глобальные переменные конфигурации",
        _text1_Font, ALIGNMENT_CENTER );
    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,670.0, -120.0, 0.0, 0.0,
        black,"Вспомогательные переменные\r\nдля обмена данными\r\nмежду процессами",
        _text2_Font, ALIGNMENT_CENTER );
    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,660.0, -220.0, 0.0, 0.0,
        black,"Очереди обработки событий",
        _text3_Font, ALIGNMENT_CENTER );
    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,870.0, -120.0, 0.0, 0.0,
        black,"Циклические и разовые события",
        _text4_Font, ALIGNMENT_CENTER );
    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,870.0, -270.0, 0.0, 0.0,
        black,"Функции",
        _text5_Font, ALIGNMENT_CENTER );
    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,910.0, 310.0, 0.0, 0.0,
        black,"Популяции агентов (нажмите\r\nна иконку популяции\r\nдля подробных данных)",
        _text6_Font, ALIGNMENT_CENTER );
    wall1 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 80.0, 80.0, 0.0, 740.0, 20.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 80.0, 100.0, 0.0, 20.0, 420.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall2 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 100.0, 500.0, 0.0, 720.0, 20.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall3 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 800.0, 160.0, 0.0, 20.0, 340.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall4 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 660.0, 360.0, 0.0, 140.0, 20.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall5 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 640.0, 100.0, 0.0, 20.0, 120.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall6 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 500.0, 200.0, 0.0, 140.0, 20.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall7 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 340.0, 200.0, 0.0, 100.0, 20.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall8 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 340.0, 100.0, 0.0, 20.0, 100.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall9 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 460.0, 360.0, 0.0, 140.0, 20.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall10 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 460.0, 380.0, 0.0, 20.0, 120.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    wall11 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 100.0, 280.0, 0.0, 360.0, 20.0, 0.0, 2.0, 20.0,
            WALL_FILL_HATCHING, peru );
    nodeVirus = new PointNode(this, SHAPE_DRAW_2D3D, true, 520.0, 470.0, 0.0, 10.0, magenta, false, 10.0, new PathEnd[] {} );
    nodePatch = new PointNode(this, SHAPE_DRAW_2D3D, true, 540.0, 470.0, 0.0, 10.0, lime, false, 10.0, new PathEnd[] {} );
    nodePlayground = new RectangularNode<Agent>( this, SHAPE_DRAW_2D3D, true,
    null, 0.0, 0.0, 0.0, 1000.0, 600.0, 0.0,
            null, dodgerBlue, 1.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM, new PathEnd[] {} );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataSet> _items = new ArrayList<DataSet>( 4 );
    _items.add( 
susceptibleDS 
 ); 
    _items.add( 
exposedDS 
 ); 
    _items.add( 
infectedDS 
 ); 
    _items.add( 
recoveredDS 
 ); 
    List<String> _titles = new ArrayList<>( 4 );
    _titles.add( "Восприимчивые" );
    _titles.add( "Латентные" );
    _titles.add( "Заражённые" );
    _titles.add( "Вылеченные" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<>( 4 );
    _appearances.add( new Chart2DPlot.Appearance( lightGrey, true, false, Chart.INTERPOLATION_STEP, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( gold, true, false, Chart.INTERPOLATION_STEP, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_STEP, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( green, true, false, Chart.INTERPOLATION_STEP, 1.0, Chart.POINT_NONE ) );
    plotStates = new TimePlot(
Main.this, true, 190.0, 610.0,
			260.0, 210.0,
            null, null,
            50.0, 30.0,
			180.0, 120.0, white, black, black,
            30.0, Chart.SOUTH,

100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_FIXED,

-1 
            , 
25 
, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );
    }
    viruses_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, viruses) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _viruses_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    patches_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, patches) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _patches_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    devices_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, devices) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _devices_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }



  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	


  /**
   * Constructor
   */
  public Main( Engine engine, Agent owner, AgentList<? extends Main> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    virusMove = instantiate_virusMove_xjal();
    virusDelay = instantiate_virusDelay_xjal();
    virusSink = instantiate_virusSink_xjal();
    sourceVirus = instantiate_sourceVirus_xjal();
    patchMove = instantiate_patchMove_xjal();
    patchDelay = instantiate_patchDelay_xjal();
    patchSink = instantiate_patchSink_xjal();
    sourcePatch = instantiate_sourcePatch_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Main() {
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Main( double rzero, double scanInterval ) {
    markParametersAreSet();
    this.rzero = rzero;
    this.scanInterval = scanInterval;
  }

  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
    {
      int _cnt = 
0 
;
      for ( int i = viruses.size(); i < _cnt; i++ ) {
        instantiate_viruses_xjal( i );
      }
    }
    {
      int _cnt = 
0 
;
      for ( int i = patches.size(); i < _cnt; i++ ) {
        instantiate_patches_xjal( i );
      }
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
Map<String, Set<?>> usdMapping = getRootAgent().ext(ExtRootModelAgent.class).getCustomObject(OmniverseHelper.USD_CONTEXT_COLLECTION_KEY,
()-> new LinkedHashMap<String, Set<?>>());
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level, viruses_presentation, patches_presentation, devices_presentation );
    presentation.getConfiguration3D().setBackgroundColor( silver );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "diploma.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );


    // Space setup
    {
      double _x_xjal = 
500 
;
      double _y_xjal = 
500 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
    // Creating non-replicated embedded objects
    setupParameters_virusMove_xjal( virusMove, null );
    doBeforeCreate_virusMove_xjal( virusMove, null );
    virusMove.createAsEmbedded();
    setupParameters_virusDelay_xjal( virusDelay, null );
    doBeforeCreate_virusDelay_xjal( virusDelay, null );
    virusDelay.createAsEmbedded();
    setupParameters_virusSink_xjal( virusSink, null );
    doBeforeCreate_virusSink_xjal( virusSink, null );
    virusSink.createAsEmbedded();
    setupParameters_sourceVirus_xjal( sourceVirus, null );
    doBeforeCreate_sourceVirus_xjal( sourceVirus, null );
    sourceVirus.createAsEmbedded();
    setupParameters_patchMove_xjal( patchMove, null );
    doBeforeCreate_patchMove_xjal( patchMove, null );
    patchMove.createAsEmbedded();
    setupParameters_patchDelay_xjal( patchDelay, null );
    doBeforeCreate_patchDelay_xjal( patchDelay, null );
    patchDelay.createAsEmbedded();
    setupParameters_patchSink_xjal( patchSink, null );
    doBeforeCreate_patchSink_xjal( patchSink, null );
    patchSink.createAsEmbedded();
    setupParameters_sourcePatch_xjal( sourcePatch, null );
    doBeforeCreate_sourcePatch_xjal( sourcePatch, null );
    sourcePatch.createAsEmbedded();
	 // Port connectors with non-replicated objects
    virusSink.in.connect( virusDelay.out ); // connector
    virusDelay.in.connect( virusMove.out ); // connector1
    sourcePatch.out.connect( patchMove.in ); // connector5
    patchMove.out.connect( patchDelay.in ); // connector3
    patchDelay.out.connect( patchSink.in ); // connector4
    sourceVirus.out.connect( virusMove.in ); // connector2
    // Creating replicated embedded objects
    viruses.setEnvironment( this );
    for ( int i = 0; i < viruses.size(); i++ ) {
      Virus _a = viruses.get(i);
      setupParameters_viruses_xjal( _a, i, null );
      doBeforeCreate_viruses_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    patches.setEnvironment( this );
    for ( int i = 0; i < patches.size(); i++ ) {
      Patch _a = patches.get(i);
      setupParameters_patches_xjal( _a, i, null );
      doBeforeCreate_patches_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    devices.setEnvironment( this );
    for ( int i = 0; i < devices.size(); i++ ) {
      IoTDevice _a = devices.get(i);
      setupParameters_devices_xjal( _a, i, null );
      doBeforeCreate_devices_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    processVirusQueue.start();
    detectionEvent.start();
    responseEvent.start();
    developEvent.start();
    deployEvent.start();
    for (Agent embeddedObject : viruses) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : patches) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : devices) {
      embeddedObject.startAsEmbedded();
    }
    virusMove.startAsEmbedded();
    virusDelay.startAsEmbedded();
    virusSink.startAsEmbedded();
    sourceVirus.startAsEmbedded();
    patchMove.startAsEmbedded();
    patchDelay.startAsEmbedded();
    patchSink.startAsEmbedded();
    sourcePatch.startAsEmbedded();
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

showMainMenu();

detectionEvent.reset();
responseEvent.reset();
developEvent.reset();
deployEvent.reset();

if (devices != null && devices.size() > 0) {
	IoTDevice target = null;
	if (!patientZeroName.isEmpty()) {
		for (IoTDevice d : devices) {
			if (patientZeroName.equals(d.deviceName)) {
				target = d;
				break;
			}
		}
		if (target == null) {
			traceln("[" + time() + "] Устройство '"
					+ patientZeroName
					+ "' не найдено, patient zero выбран случайно.");
		}
	}
	if (target == null) {
		target = devices
				.get(uniform_discr(0, devices.size() - 1));
	}
	createVirus(rzero, target);
} 
 }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
    configs = 
new java.util.ArrayList<DeviceConfig>() 
;
    isolatedSegments = 
new ArrayList<String>() 
;
    autoIsolation = 
false 
;
    passwordDictionary = 
new ArrayList<String>() {
	{
		add("admin:admin");
		add("admin:12345");
		add("admin:123456");
		add("admin:password");
		add("admin:1234");
		add("admin:1234567890");
		add("admin:12345678");
		add("admin:1111111");
		add("admin:123123");
		add("admin:00000000");
		add("admin:88888888");
		add("admin:66666666");
		add("admin:admin123");
		add("admin:admin1");
		add("admin:pass");
		add("admin:1111");
		add("admin:55555");
		add("admin:1234567");
		add("admin:123456789");
		add("admin:0123456");
		add("admin:123");
		add("admin:54321");
		add("admin:password1");
		add("admin:qwerty");
		add("admin:abc123");
		add("admin:password123");
		add("root:root");
		add("root:12345");
		add("root:123456");
		add("root:password");
		add("root:admin");
		add("root:1234");
		add("root:12345678");
		add("root:root123");
		add("root:pass");
		add("root:toor");
		add("root:rooter");
		add("guest:guest");
		add("guest:12345");
		add("guest:password");
		add("support:support");
		add("user:user");
		add("user:12345");
		add("user:password");
		add("ubnt:ubnt");
		add("ftp:ftp");
		add("test:test");
		add("admin:");
		add("root:");
		add("guest:");
		add(":");
	}
} 
;
    attackMode = 
"combined" 
;
    patientZeroName = 
"" 
;
    timeToDetect = 
5.0 
;
    timeToRespond = 
2.0 
;
    timeToDevelopPatch = 
10.0 
;
    timeToDeploy = 
1.0 
;
    firstInfectionTime = 
-1.0 
;
    networkSpeed = 
1.0 
;
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( viruses );
    list.add( virusMove );
    list.add( virusDelay );
    list.add( virusSink );
    list.add( sourceVirus );
    list.add( patchMove );
    list.add( patchDelay );
    list.add( patchSink );
    list.add( sourcePatch );
    list.add( patches );
    list.add( devices );
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    processVirusQueue.onDestroy();
    detectionEvent.onDestroy();
    responseEvent.onDestroy();
    developEvent.onDestroy();
    deployEvent.onDestroy();
    for (Agent _item : viruses) {
      _item.onDestroy();
    }
    virusMove.onDestroy();
    virusDelay.onDestroy();
    virusSink.onDestroy();
    sourceVirus.onDestroy();
    patchMove.onDestroy();
    patchDelay.onDestroy();
    patchSink.onDestroy();
    sourcePatch.onDestroy();
    for (Agent _item : patches) {
      _item.onDestroy();
    }
    for (Agent _item : devices) {
      _item.onDestroy();
    }
  // Analysis Data Elements
  	for (int _pIdx = 0; _pIdx < plotStates.getCount(); _pIdx++) {
  		DataSet _ds = plotStates.get(_pIdx);
  		_ds.destroyUpdater_xjal();
  		String _t = plotStates.getTitle(_pIdx);
  		if (_t.isEmpty()) {
  			_t = "Value_" + _pIdx;
  		}
  		logToDB( _ds, "plotStates : " + _t );
  	}
    infectedDS.destroyUpdater_xjal();
    susceptibleDS.destroyUpdater_xjal();
    exposedDS.destroyUpdater_xjal();
    recoveredDS.destroyUpdater_xjal();
    logToDB( infectedDS, "infectedDS" );
    logToDB( susceptibleDS, "susceptibleDS" );
    logToDB( exposedDS, "exposedDS" );
    logToDB( recoveredDS, "recoveredDS" );
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    for (Agent _item : viruses) {
      _item.doFinish();
    }
    virusMove.doFinish();
    virusDelay.doFinish();
    virusSink.doFinish();
    sourceVirus.doFinish();
    patchMove.doFinish();
    patchDelay.doFinish();
    patchSink.doFinish();
    sourcePatch.doFinish();
    for (Agent _item : patches) {
      _item.doFinish();
    }
    for (Agent _item : devices) {
      _item.doFinish();
    }
  }


}
