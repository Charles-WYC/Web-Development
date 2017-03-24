<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "shipment".
 *
 * @property string $bookID
 * @property string $indentID
 * @property string $number
 *
 * @property BookStack $book
 * @property Indent $indent
 */
class Shipment extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'shipment';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['bookID', 'indentID'], 'required'],
            [['bookID', 'indentID', 'number'], 'number'],
            [['bookID'], 'exist', 'skipOnError' => true, 'targetClass' => BookStack::className(), 'targetAttribute' => ['bookID' => 'bookID']],
            [['indentID'], 'exist', 'skipOnError' => true, 'targetClass' => Indent::className(), 'targetAttribute' => ['indentID' => 'indentID']],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'bookID' => 'Book ID',
            'indentID' => 'Indent ID',
            'number' => 'Number',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getBook()
    {
        return $this->hasOne(BookStack::className(), ['bookID' => 'bookID']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getIndent()
    {
        return $this->hasOne(Indent::className(), ['indentID' => 'indentID']);
    }
}
