<?php
/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
include_once $GLOBALS['THRIFT_ROOT'].'/Thrift.php';


class ConnectionInfo {
  static $_TSPEC;

  public $username = null;
  public $password = null;
  public $address = null;
  public $port = null;
  public $type = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'username',
          'type' => TType::STRING,
          ),
        2 => array(
          'var' => 'password',
          'type' => TType::STRING,
          ),
        3 => array(
          'var' => 'address',
          'type' => TType::STRING,
          ),
        4 => array(
          'var' => 'port',
          'type' => TType::STRING,
          ),
        5 => array(
          'var' => 'type',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['username'])) {
        $this->username = $vals['username'];
      }
      if (isset($vals['password'])) {
        $this->password = $vals['password'];
      }
      if (isset($vals['address'])) {
        $this->address = $vals['address'];
      }
      if (isset($vals['port'])) {
        $this->port = $vals['port'];
      }
      if (isset($vals['type'])) {
        $this->type = $vals['type'];
      }
    }
  }

  public function getName() {
    return 'ConnectionInfo';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->username);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->password);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->address);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 4:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->port);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 5:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->type);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('ConnectionInfo');
    if ($this->username !== null) {
      $xfer += $output->writeFieldBegin('username', TType::STRING, 1);
      $xfer += $output->writeString($this->username);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->password !== null) {
      $xfer += $output->writeFieldBegin('password', TType::STRING, 2);
      $xfer += $output->writeString($this->password);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->address !== null) {
      $xfer += $output->writeFieldBegin('address', TType::STRING, 3);
      $xfer += $output->writeString($this->address);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->port !== null) {
      $xfer += $output->writeFieldBegin('port', TType::STRING, 4);
      $xfer += $output->writeString($this->port);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->type !== null) {
      $xfer += $output->writeFieldBegin('type', TType::STRING, 5);
      $xfer += $output->writeString($this->type);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

?>
