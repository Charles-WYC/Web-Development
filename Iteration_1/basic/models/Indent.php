<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "indent".
 *
 * @property string $indentID
 * @property string $username
 * @property string $amount
 *
 * @property User $username0
 * @property Shipment[] $shipments
 * @property BookStack[] $books
 */
class Indent extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'indent';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['indentID'], 'required'],
            [['indentID', 'amount'], 'number'],
            [['username'], 'string', 'max' => 20],
            [['username'], 'exist', 'skipOnError' => true, 'targetClass' => User::className(), 'targetAttribute' => ['username' => 'username']],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'indentID' => 'Indent ID',
            'username' => 'Username',
            'amount' => 'Amount',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getUsername0()
    {
        return $this->hasOne(User::className(), ['username' => 'username']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getShipments()
    {
        return $this->hasMany(Shipment::className(), ['indentID' => 'indentID']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getBooks()
    {
        return $this->hasMany(BookStack::className(), ['bookID' => 'bookID'])->viaTable('shipment', ['indentID' => 'indentID']);
    }
}
